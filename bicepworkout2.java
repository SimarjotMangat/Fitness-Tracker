package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class bicepworkout2 extends AppCompatActivity {
    int endpoint=0;

    int seconds=0;
    boolean running=false;
    int newtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicepworkout2);
        runtimer();

        TextView textView=(TextView)findViewById(R.id.timer);

        //3 buttons
        Button start=(Button)findViewById(R.id.startbutton);
        Button reset=(Button)findViewById(R.id.resetbutton);
        Button stop=(Button)findViewById(R.id.pausebutton);





        Intent i=getIntent();

        String ab=i.getStringExtra("image");
        String Timer=i.getStringExtra("timer");
        if(Timer.equals("5-Minutes")){
            endpoint=1;
            newtime=endpoint*60;

        }
        else if(Timer.equals("10-Minutes")){
            endpoint=10;
            newtime=endpoint*60;


        }
        else{
            endpoint=30;
            newtime=endpoint*60;


        }


        //Toast.makeText(getApplicationContext(),"hello "+ ab,Toast.LENGTH_LONG).show();
        if(ab.equals("BarbellCurl")){
            ImageView I= (ImageView)findViewById(R.id.exerciseimg);

            I.setImageResource(R.drawable.barbellcurl12);
        }
        else if(ab.equals("InclineCurls")){
            ImageView I= (ImageView)findViewById(R.id.exerciseimg);
            I.setImageResource(R.drawable.incline);

        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                running=true;
                start.setVisibility(view.INVISIBLE);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
                seconds=0;
                start.setVisibility(view.VISIBLE);
            }
        });

        //initCountDownTimer(5);




    }
    public void runtimer(){
        TextView textView=(TextView)findViewById(R.id.timer);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours= seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                textView.setText(time);


                 if(seconds==newtime){
                     handler.removeCallbacks(null);

                    textView.setText("Workout over congo");
                    running=false;
                }
                 else if(running==true) {
                     seconds++;

                 }
                handler.postDelayed(this,1000);

            }
        });




    }

































//    public void initCountDownTimer(int time){
//        TextView textView=(TextView)findViewById(R.id.timer);
//
//        new CountDownTimer(30000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                textView.setText(""+ millisUntilFinished / 1000);
//            }
//
//            public void onFinish() {
//                textView.setText("Congo! work Out Over ");
//
//            }
//        }.start();
//    }
}