package com.example.fitness_tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<bicep> {
    public adapter(Activity context, ArrayList<bicep>biceps){
        super(context,0,biceps);

    }
    @Nullable
    @Override
    public bicep getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listview;
        listview = convertView;
        if(listview==null){
            listview= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        bicep current=getItem(position);
        TextView t1=(TextView)listview.findViewById(R.id.textbicep1);
        assert current != null;
        t1.setText(current.getHeading());
        TextView t2=(TextView)listview.findViewById(R.id.text2);
        t2.setText(current.getBody());
        ImageView im=(ImageView)listview.findViewById(R.id.bicep100);
        im.setImageResource(current.getId());
        ImageView b1=(ImageView) listview.findViewById(R.id.workout_button);
        b1.setImageResource(current.get_btn());
        return  listview;




    }
}
