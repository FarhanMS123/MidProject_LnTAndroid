package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick_lnkClose(View view){
        this.finish();
    }

    public void onClick_lnkTestDrive(View view){
        Intent actTestDrive = new Intent(this, TestDrive.class);
        startActivity(actTestDrive);
    }
}