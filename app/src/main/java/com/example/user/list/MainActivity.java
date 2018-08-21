package com.example.user.list;

import android.graphics.Movie;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SensorDescriptionAdapter sensorDescriptionAdapter;
    TextView tvText;
    Sensor sensorLight;
    SensorManager sensorManager;
    List<Sensor> sensorslist;
    List<SensorDescription> sensorDescriptions=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorslist = sensorManager.getSensorList(Sensor.TYPE_ALL);///список всех сенсоров
        for (Sensor sensor : sensorslist) {
            sensorDescriptions.add(new SensorDescription(sensor.getName(),String.valueOf(sensor.getType()),sensor.getVendor(), String.valueOf(sensor.getVersion()), String.valueOf(sensor.getMaximumRange()),String.valueOf(sensor.getResolution())));

        }
        sensorDescriptionAdapter=  new SensorDescriptionAdapter(this,sensorDescriptions);
        recyclerView.setAdapter(sensorDescriptionAdapter);
        sensorDescriptionAdapter.notifyDataSetChanged();

        }



    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listenerLight, sensorLight);
    }

    SensorEventListener listenerLight = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            tvText.setText(String.valueOf(event.values[0]));
        }
    };


}






