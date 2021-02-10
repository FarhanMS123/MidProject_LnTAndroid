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
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));
        items.add(new CarInfoAdapter.CarInfo(R.drawable.menthol_icon, "Mobil 1", "Brand 1", "Tipe 1", "100km/h"));

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