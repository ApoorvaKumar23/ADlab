package com.example.experiment6; // Update this to match your package name

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the WebView by its ID
        WebView webView = findViewById(R.id.webView);

        // Enable JavaScript (optional)
        webView.getSettings().setJavaScriptEnabled(true);

        // Set the WebViewClient to open links inside the WebView itself
        webView.setWebViewClient(new WebViewClient());

        // Load a website URL
        webView.loadUrl("https://www.example.com"); // Replace with the URL you want to display
    }
}
