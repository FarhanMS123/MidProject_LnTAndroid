package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class license extends AppCompatActivity {
    WebView wvLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        wvLicense = (WebView) findViewById(R.id.wvLicense);
        wvLicense.loadUrl("file:///android_asset/license.html");
        wvLicense.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClick_lnkBack(View view){
        this.finish();
    }
}