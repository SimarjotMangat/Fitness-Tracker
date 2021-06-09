package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;

public class showstats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showstats);
        Intent i=getIntent();
        String day1=i.getStringExtra("day1");
        String day2=i.getStringExtra("day2");
        String day3=i.getStringExtra("day3");
        String day4=i.getStringExtra("day4");

        String day5=i.getStringExtra("day5");
        String day6=i.getStringExtra("day6");
        String day7=i.getStringExtra("day7");
        int day11=Integer.parseInt(day1);
        int day22=Integer.parseInt(day2);
        int day33=Integer.parseInt(day3);
        int day44=Integer.parseInt(day4);
        int day55=Integer.parseInt(day5);
        int day66=Integer.parseInt(day6);
        int day77=Integer.parseInt(day7);



        BarChart bar=(BarChart)findViewById(R.id.barchart);
        ArrayList<BarEntry> info=new ArrayList<>();
        info.add(new BarEntry(1,day11));
        info.add(new BarEntry(2,day22));
        info.add(new BarEntry(3,day33));
        info.add(new BarEntry(4,day44));
        info.add(new BarEntry(5,day55));
        info.add(new BarEntry(6,day66));
        info.add(new BarEntry(7,day77));

        BarDataSet barDataSet=new BarDataSet(info,"Report");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(20f);
        barDataSet.setLabel("Weight Day Wise");
        BarData n1=new BarData(barDataSet);



        bar.setFitBars(true);
        bar.setData(n1);
        bar.getDescription().setText("day Wise weight");

        bar.animateY(2000);





    }
}