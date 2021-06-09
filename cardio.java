package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class cardio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
        ArrayList<bicep> arr = new ArrayList<>();
        arr.add(new bicep("Spartacus", "  Step forward with your right foot and lower your body into a lunge. As you lunge, rotate your upper body to the right [B]. Return to the starting position, and repeat with your left leg.",

                R.drawable.cardioimage, R.drawable.play));
        arr.add(new bicep("High-Knees", "Lift up right knee as high as it will go and raise the opposite arm, then switch quickly so left knee is up before right foot lands. Continue pulling knees up quirky for as long as desired.",
                R.drawable.highkness, R.drawable.play));
        arr.add(new bicep("Super-Short Cardio", "Start with your feet shoulder-width apart. Take a big jump to right and land on your right foot, swinging your left leg behind right leg and swinging your arms for balance. ",
                R.drawable.supershortcardio, R.drawable.play));
        adapter a1 = new adapter(this, arr);
        ImageView gif = (ImageView) findViewById(R.id.workout_button);

        ListView li = (ListView) findViewById(R.id.list1);
        li.setAdapter(a1);
    }
}