package com.example.realnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {
    String name , domains , web_pages , alpha_two_code , state, country;
    WebView webView;
    Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = getIntent().getStringExtra("name");
        alpha_two_code = getIntent().getStringExtra("alpha_two_code");
        country = getIntent().getStringExtra("country");
        webView = (WebView)findViewById(R.id.wb);
        textView = (TextView)findViewById(R.id.tt3);
        textView.setText(name);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());
        name.replace(" " , "_");
        webView.loadUrl("https://en.wikipedia.org/wiki/"+name);
    }
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}