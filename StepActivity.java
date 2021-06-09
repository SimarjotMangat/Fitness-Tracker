package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.Console;

public class StepActivity extends AppCompatActivity implements SensorEventListener {
    public TextView t1;
    public SensorManager sensorManager;
    public Sensor nstepcounter;
    public boolean iscounterpresent;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        t1=(TextView)findViewById(R.id.stepcount);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){

            nstepcounter=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            iscounterpresent=true;

        }
        else {
            t1.setText("Counter Sensor not present");
            iscounterpresent=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(iscounterpresent){
            count=(int) sensorEvent.values[0];
            t1.setText(String.valueOf(count));
        }
        Log.d("count",""+ count);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.registerListener(this,nstepcounter,SensorManager.SENSOR_DELAY_NORMAL);

        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.unregisterListener(this,nstepcounter);
        }

    }


}