package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView lnkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_lnkRegister(View view){
        Intent actRegister = new Intent(this, Register.class);
        startActivity(actRegister);
    }

    public void onClick_lnkLicense(View view){
        Intent actLicense = new Intent(this, license.class);
        startActivity(actLicense);
    }

    public void onClick_lnkSkip(View view){
        Intent actHome = new Intent(this, Home.class);
        startActivity(actHome);
    }
}