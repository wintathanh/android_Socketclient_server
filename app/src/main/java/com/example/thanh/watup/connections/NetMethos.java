package com.example.thanh.watup.connections;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;

public class NetMethos {

    //<editor-fold desc="LinkProperties to IP">
    public static String getAllIpAddresses(ConnectivityManager cm) {
        LinkProperties prop = cm.getLinkProperties(cm.getActiveNetwork());
        return formatIpAddresses(prop);
    }

    private static String formatIpAddresses(LinkProperties prop) {
        if (prop == null) return null;
        Iterator<LinkAddress> iter = prop.getLinkAddresses().iterator();
        if (!iter.hasNext()) return null;
        String addresses = "";
        while (iter.hasNext()) {
            addresses += iter.next().getAddress().getHostAddress();
            if (iter.hasNext()) addresses += "\n";
        }
        return addresses;
    }
    //</editor-fold>

    //<editor-fold desc="Wifi IP converter from BigInteger">

    public static String getIpWifi(Context c){
        try {
            WifiManager wm = (WifiManager) c.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wi = wm.getConnectionInfo();
            int ip = wi.getIpAddress();

            String s = String.format("%d.%d.%d.%d", (ip & 0xff), (ip >> 8 & 0xff), (ip >> 16 & 0xff), (ip >> 24 & 0xff));
            Log.d("<<IPPPP", s);
            return s;
        } catch (Exception e) {
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="net Interface">
    public static String getAllIpIner(){
        String s = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress.isLoopbackAddress()) {continue;}
                    s += "ip:" + inetAddress.getHostAddress() + "\n";
                }
            }
        } catch (Exception ex) {
            Log.e("IP Address", ex.toString());
        }
        Log.d("<<ipSSSS","\n"+ s);
        return s;
    }
    //</editor-fold >
}
