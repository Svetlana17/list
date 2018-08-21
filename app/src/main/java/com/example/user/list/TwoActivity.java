package com.example.user.list;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {
    public static final String SENSORS_ITEM ="sensors";
    private Sensor mSensor;
    TextView name;
    TextView vendor;
    TextView version;
    TextView max;
    TextView resolution;
    SensorDescription sensorDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        name=(TextView) findViewById(R.id.name);
        vendor = (TextView) findViewById(R.id.vendor);
        version= (TextView) findViewById(R.id.version);
        max=(TextView) findViewById(R.id.max);
        resolution=(TextView) findViewById(R.id.resolution);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
             sensorDescription=arguments.getParcelable(TwoActivity.SENSORS_ITEM);
            name.setText(sensorDescription.getName());
        }



    }
}

