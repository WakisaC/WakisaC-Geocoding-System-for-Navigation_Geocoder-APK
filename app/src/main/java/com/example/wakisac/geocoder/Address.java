package com.example.wakisac.geocoder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Address extends AppCompatActivity {

    Button button;
    EditText area,street,houseNum;
    String getArea,getStreet,getHouseNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button =(Button)findViewById(R.id.getLocation);
        area = (EditText)findViewById(R.id.residentialArea);
        street = (EditText)findViewById(R.id.street);
        houseNum = (EditText)findViewById(R.id.houseNum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(Address.this, ""+getHouseNum +getArea+getStreet, Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void result(){
        //   getLocation();
        getArea = area.getText().toString();
        getStreet = street.getText().toString();
        getHouseNum = houseNum.getText().toString();

        // get the input to the mapActivity
        Intent intent = new Intent(this,MapsActivity.class);

        intent.putExtra("area",getArea);
        intent.putExtra("street",getStreet);
        intent.putExtra("houseNum",getHouseNum);
        startActivity(intent);

    }

    public void getLocation(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

}
