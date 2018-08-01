package com.example.thanh.watup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.thanh.watup.connections.NetMethos;
import com.example.thanh.watup.connections.TcpCLienAsyn;
import com.example.thanh.watup.connections.TcpconAsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.text.Format;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    static int f = 0;
    private EditText message;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message1);
        send = findViewById(R.id.button2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new TcpCLienAsyn().execute(message.getText().toString());
                    }
                }).start();
            }
        });

        final ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                new TcpconAsync().startServer();


            }
        }).start();
    }
}
