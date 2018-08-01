package com.example.thanh.watup.connections;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpCLienAsyn extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            InetAddress serverAddr = InetAddress.getByName("192.168.68.126");
            Socket client;
            boolean end = false;
            while (!end) {
                client = new Socket(serverAddr, Integer.parseInt("50000"));
                OutputStream os = client.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println(objects[0].toString());

                Log.d("ASYNclientclient", objects[0].toString());
                Log.d("ASYNclient", "ffff");

                client.close();
                return true;

            }
        } catch (NumberFormatException e) {
            Log.d("<<sserverNUMFORT>>", e.getMessage());
        } catch (UnknownHostException e) {
            Log.d("<<sserverUNKNOW>>", e.getMessage());
        } catch (IOException e) {
            Log.d("<<sserverIOEX>>", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
//        if((boolean)o)Log.d("<<CLIENT: ","success to end");
//        else Log.d("<<CLIENT: ","send fail");
    }
}
