package com.example.thanh.watup.connections;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpconAsync extends AsyncTask {

    public static final String REQUIRE_CONN = "require_connection";
    public static final String END_CONN = "Bye_Bye_u";

    public void startServer() {
        try {
            ServerSocket ss = new ServerSocket(50000);
            Log.d("<<SErVer",ss.getLocalPort()+"");
            while (true) {
                Socket server = ss.accept();
                Log.d("TCP Server", "Client Connect ");
                //doc ghi network
                InputStream is = server.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String a = br.readLine();

                Log.d("<< server >>", a + " + " + a);
                server.close();
            }
        } catch (IOException e) {
            Log.d("<<sserver>>", e.getMessage());
        }
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        return null;
    }
}
