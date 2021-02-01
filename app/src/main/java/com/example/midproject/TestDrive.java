package com.example.midproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class TestDrive extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TextWatcher{
    TestDrive mainClass;

    Spinner spTypeVehicle;
    EditText etBrand;
    EditText etName;
    EditText etLicense;
    EditText etTopSpeed;
    EditText etGasCapacity;
    EditText etWheel;
    Spinner spTypeOfKind;
    TextView tvQuest;
    EditText etQuest;
    Button btnSubmit;

    LinearLayout llDesc;
    TextView tvType;
    Button btnTestDrive;
    TextView tvOnce;
    TextView tvLabelPrice;
    EditText etPrice;
    TextView tvPrice;

    Boolean isInvalid = false;

    class _temp{
        CharSequence s = "a";
        int start = 0;
        int before = 0;
        int count = 0;
    }

    private _temp temp = new _temp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drive);

        mainClass = this;

        spTypeVehicle = findViewById(R.id.spTypeVehicle);
        etBrand = findViewById(R.id.etBrand);
        etName = findViewById(R.id.etName);
        etLicense = findViewById(R.id.etLicense);
        etTopSpeed = findViewById(R.id.etTopSpeed);
        etGasCapacity = findViewById(R.id.etGasCapacity);
        etWheel = findViewById(R.id.etWheel);
        spTypeOfKind = findViewById(R.id.spTypeOfKind);
        tvQuest = findViewById(R.id.tvQuest);
        etQuest = findViewById(R.id.etQuest);
        btnSubmit = findViewById(R.id.btnSubmit);

        llDesc = findViewById(R.id.llDesc);
        tvType = findViewById(R.id.tvType);
        btnTestDrive = findViewById(R.id.btnTestDrive);
        tvOnce = findViewById(R.id.tvOnce);
        tvLabelPrice = findViewById(R.id.tvLabelPrice);
        etPrice = findViewById(R.id.etPrice);
        tvPrice = findViewById(R.id.tvPrice);

        spTypeVehicle.setOnItemSelectedListener(this);
        etBrand.addTextChangedListener(this);
        etName.addTextChangedListener(this);
        etLicense.addTextChangedListener(this);
        etTopSpeed.addTextChangedListener(this);
        etGasCapacity.addTextChangedListener(this);
        etWheel.addTextChangedListener(this);
        etQuest.addTextChangedListener(this);
        etPrice.addTextChangedListener(this);
    }

    public void onClick_lnkBack(View view){
        this.finish();
    }

    public void onItemSelected_spTypeVehicle(AdapterView<?> parent, View view, int position, long id){
        ArrayAdapter<CharSequence> adapter;
        switch (position){
            case 0: // Mobil
                adapter = ArrayAdapter.createFromResource(this, R.array.typesOfCar, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spTypeOfKind.setAdapter(adapter);

                tvQuest.setText("Entertainment System Amount");
                break;
            case 1: // Motor
                adapter = ArrayAdapter.createFromResource(this, R.array.typesOfMotor, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spTypeOfKind.setAdapter(adapter);

                tvQuest.setText("Helm Amount");
                break;
        }
    }

    public void onClick_btnSubmit(View view){
        onTextChanged(temp.s, temp.start, temp.before, temp.count);

        if(isInvalid){
            llDesc.setVisibility(View.GONE);
            return;
        }

        llDesc.setVisibility(View.VISIBLE);
        tvType.setText(spTypeVehicle.getSelectedItem().toString() + " " + etName.getText());
        tvOnce.setText("Brand: " + etBrand.getText() +
                     "\nName: " + etName.getText() +
                     "\nLicense Plate: " + etLicense.getText() +
                     "\nType: " + spTypeOfKind.getSelectedItem().toString() +
                     "\nGas Capacity: " + etGasCapacity.getText() +
                     "\nTop Speed: " + etTopSpeed.getText() +
                     "\nWheel(s): " + etWheel.getText());

        switch(spTypeVehicle.getSelectedItemPosition()){
            case 0: // Mobil
                tvLabelPrice.setVisibility(View.GONE);
                etPrice.setVisibility(View.GONE);
                tvPrice.setVisibility(View.GONE);
                break;
            case 1: // Motor
                tvLabelPrice.setVisibility(View.VISIBLE);
                etPrice.setVisibility(View.VISIBLE);
                tvPrice.setVisibility(View.VISIBLE);

                tvOnce.setText(tvOnce.getText() + "\nHelm: " + etQuest.getText());
                break;
        }
    }

    public void onClick_btnTestDrive(View view){
        onClick_btnSubmit((View) btnSubmit);
        if(isInvalid) return;

        switch(spTypeVehicle.getSelectedItemPosition()){
            case 0: // Mobil
                Toast.makeText(mainClass, "Turning on entertainment system... " + etQuest.getText(), Toast.LENGTH_SHORT).show();
                if(spTypeOfKind.getSelectedItemPosition() == 1){
                    (new Handler()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mainClass, "Boosting!", Toast.LENGTH_SHORT).show();
                        }
                    }, 3000);
                }
                break;
            case 1: // Motor
                Toast.makeText(mainClass, etName.getText() + " is standing!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // ##### HELPER #############################################
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        isInvalid = false;

        temp.s = s;
        temp.start = start;
        temp.before = before;
        temp.count = count;

        if(etBrand.getText().length() < 5) {
            etBrand.setError("Brand must have at least 5 characters.");
            isInvalid = true;
        }

        if(etName.getText().length() < 5){
            etName.setError("Name must have at least 5 characters.");
            isInvalid = true;
        }

        if(!(Pattern.compile("^[A-Z] [0-9]{1,4} [A-Z]{1,3}$").matcher(etLicense.getText()).find())){
            etLicense.setError("License must follow Police Rules and in UPPER case. It would filled with 1 Alphabetical, followed by a space and 1-4 digits, and followed by a space and 1-3 characters.\nFor example : A 1 B, D 1234 GHI, Z 123 AJ, etc...");
            isInvalid = true;
        }

        if(!(Pattern.compile("^[0-9]+$").matcher(etTopSpeed.getText()).find())
                || (Integer.parseInt(etTopSpeed.getText().toString()) < 100 || Integer.parseInt(etTopSpeed.getText().toString()) > 250)){
            etTopSpeed.setError("Top Speed must in 100 to 250.");
            isInvalid = true;
        }

        if(!(Pattern.compile("^[0-9]+$").matcher(etGasCapacity.getText()).find())
                || (Integer.parseInt(etGasCapacity.getText().toString()) < 30 || Integer.parseInt(etGasCapacity.getText().toString()) > 60)){
            etGasCapacity.setError("Gas Capacity must in 30 to 60.");
            isInvalid = true;
        }

        if(spTypeVehicle.getSelectedItemPosition() == 0 && (!(Pattern.compile("^[0-9]+$").matcher(etWheel.getText()).find())
                || (Integer.parseInt(etWheel.getText().toString()) < 4 || Integer.parseInt(etWheel.getText().toString()) > 6))){ // mobil
            etWheel.setError("Mobil's Wheels must in 4 to 6.");
            isInvalid = true;
        }else if(spTypeVehicle.getSelectedItemPosition() == 1 && (!(Pattern.compile("^[0-9]+$").matcher(etWheel.getText()).find())
                || (Integer.parseInt(etWheel.getText().toString()) < 2 || Integer.parseInt(etWheel.getText().toString()) > 3))){ // motor
            etWheel.setError("Motor's Wheels must in 2 to 3.");
            isInvalid = true;
        }

        if(!(Pattern.compile("^[0-9]+$").matcher(etQuest.getText()).find()) || Integer.parseInt(etQuest.getText().toString()) < 1){
            etQuest.setError("Vehicle's Facility must has at least 1.");
            isInvalid = true;
        }

        int facility = 0;
        int price = 0;

        if(!(Pattern.compile("^[0-9]+$").matcher(etQuest.getText()).find())) facility = 0;
            else facility = Integer.parseInt(etQuest.getText().toString());
        if(!(Pattern.compile("^[0-9]+$").matcher(etPrice.getText()).find())) price = 0;
            else price = Integer.parseInt(etPrice.getText().toString());

        int totalPrice = facility * price;

//        Log.d("Mamamia", facility);
        tvPrice.setText("Rp. " + totalPrice + ",-");
    }

    @Override
    public void afterTextChanged(Editable s) {
        //
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // https://developer.android.com/reference/android/widget/AdapterView.OnItemSelectedListener.html
        // spTypeVehicle.getSelectedView() == view;
        // spTypeVehicle.getSelectedItemPosition() == position
        // spTypeVehicle.getSelectedItemId() == id;
        // spTypeVehicle.getSelectedItem().toString() == ((TextView) view).getText();
        // TextView textView = (TextView) view;
        // (Spinner) view.getParent() == (Spinner) parent;
        // Log.d("Mamamia", "Ex1634 (" + parent.getId() + ", " + ((Spinner) view.getParent()).getId() + ", " + ((Spinner) view.getParent() == (Spinner) parent) + ")");

        if(view != null) {
            switch (parent.getId()) {
                case R.id.spTypeVehicle:
                    onItemSelected_spTypeVehicle(parent, view, position, id);
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }

}