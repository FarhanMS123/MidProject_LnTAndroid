package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TestDrive extends AppCompatActivity {
    TestDrive thisClass;

    Spinner spTypeVehicle;
    EditText etBrand;
    EditText etName;
    EditText etLicense;
    EditText etTopSpeed;
    EditText etGasCapacity;
    EditText etWheel;
    Spinner spTypeOfKind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drive);

        thisClass = this;

        spTypeVehicle = (Spinner) findViewById(R.id.spTypeVehicle);
        etBrand = (EditText) findViewById(R.id.etBrand);
        etName = (EditText) findViewById(R.id.etName);
        etLicense = (EditText) findViewById(R.id.etLicense);
        etTopSpeed = (EditText) findViewById(R.id.etTopSpeed);
        etGasCapacity = (EditText) findViewById(R.id.etGasCapacity);
        etWheel = (EditText) findViewById(R.id.etWheel);
        spTypeOfKind = (Spinner) findViewById(R.id.spTypeOfKind);

        spTypeVehicle.setOnItemSelectedListener(new onItemSelectedListener_spTypeVehicle());

        etBrand.addTextChangedListener(new watch_etBrand(etBrand));
    }

    public void onClick_lnkBack(View view){
        this.finish();
    }

    public class onItemSelectedListener_spTypeVehicle extends Helper_AdapterView_OnItemSelectedListener{

        // https://developer.android.com/reference/android/widget/AdapterView.OnItemSelectedListener.html
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spTypeVehicle.getSelectedView() == view;
//                spTypeVehicle.getSelectedItemPosition() == position
//                spTypeVehicle.getSelectedItemId() == id;
//                spTypeVehicle.getSelectedItem().toString() == ((TextView) view).getText();

            ArrayAdapter<CharSequence> adapter;
            switch (position){
                case 0:
                    adapter = ArrayAdapter.createFromResource(thisClass, R.array.typesOfCar, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTypeOfKind.setAdapter(adapter);
                    break;
                case 1:
                    adapter = ArrayAdapter.createFromResource(thisClass, R.array.typesOfMotor, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTypeOfKind.setAdapter(adapter);
                    break;
            }
        }
    }

    public class watch_etBrand extends Helper_TextWatcher{
        public watch_etBrand(View vw) {
            super(vw);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText _etBrand = (EditText) this.view;
            if(_etBrand.getText().length() < 5){
                _etBrand.setError("Brand must have at least 5 characters. 1931.");
            }
        }
    }

    // ##### HELPERS ##################################################
    public class Helper_AdapterView_OnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    }

    public class Helper_TextWatcher implements TextWatcher{

        public View view;
        public Helper_TextWatcher(View vw){
            view = vw;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {}
    }

}