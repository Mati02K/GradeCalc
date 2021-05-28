package com.mathesh.gradecalc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity
{
    Boolean checknet;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        checknet = checkConnection();
        if(checknet)
        {
            setContentView(R.layout.activity_webview);
            webView = findViewById(R.id.quasarweb);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://www.quasartechsolutions.in/");

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
        else
        {
            new AlertDialog.Builder(this).setTitle("Connection Failure")
                    .setMessage("Please Connect to Internet")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(WebActivity.this,MainActivity.class);
                            startActivity(intent);
                            System.exit(0);
                        }
                    }).show();
        }
    }

    public boolean checkConnection()
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo network= connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(wifi.isConnected() || network.isConnected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
