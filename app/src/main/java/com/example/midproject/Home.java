package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    RecyclerView rvCarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCarInfo = findViewById(R.id.rvCarInfo);

        ArrayList<CarInfoAdapter.CarInfo> items = new ArrayList<>();
        items.add(new CarInfoAdapter.CarInfo(R.drawable.honda_civic_sedan, "Honda Civic", "Honda", "Sedan", "130 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.mercedes_benz_e, "Mercedes Benz E", "Mercedes", "Coupe", "112 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.chevrolet_corvette, "Chevrolet Corvette", "Chevrolet", "Sport", "200 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.volvo_v60, "Volvo V60", "Volvo", "Station Wagon", "200 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.volkswagen_golf_gti, "Volkswagen Golf GTI", "Volkswagen", "Hatchback", "155 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.porsche_718_boxter, "Porsche 718 Boxster", "Volkswagen", "Convertible", "170 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.hyundai_kona, "Hyundai Kona", "Hyundai", "Sport-Utility Vehicle (SUV)", "195 rpm"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.honda_ridgeline, "Honda Ridgeline", "Honda", "Pickup Truck", "120 mph"));

        // This is a repeated items to see the recyler view scrolling feature.
        items.add(new CarInfoAdapter.CarInfo(R.drawable.honda_civic_sedan, "Honda Civic", "Honda", "Sedan", "130 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.mercedes_benz_e, "Mercedes Benz E", "Mercedes", "Coupe", "112 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.chevrolet_corvette, "Chevrolet Corvette", "Chevrolet", "Sport", "200 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.volvo_v60, "Volvo V60", "Volvo", "Station Wagon", "200 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.volkswagen_golf_gti, "Volkswagen Golf GTI", "Volkswagen", "Hatchback", "155 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.porsche_718_boxter, "Porsche 718 Boxster", "Volkswagen", "Convertible", "170 mph"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.hyundai_kona, "Hyundai Kona", "Hyundai", "Sport-Utility Vehicle (SUV)", "195 rpm"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.honda_ridgeline, "Honda Ridgeline", "Honda", "Pickup Truck", "120 mph"));

        CarInfoAdapter rvAdapter = new CarInfoAdapter(items);
        LinearLayoutManager llManager = new LinearLayoutManager(this);

        rvCarInfo.setAdapter(rvAdapter);
        rvCarInfo.setLayoutManager(llManager);
    }

    public void onClick_lnkClose(View view){
        this.finish();
    }

    public void onClick_lnkTestDrive(View view){
        Intent actTestDrive = new Intent(this, TestDrive.class);
        startActivity(actTestDrive);
    }

    public void onClick_lnkLicense(View view){
        Intent actLicense = new Intent(this, license.class);
        startActivity(actLicense);
    }
}