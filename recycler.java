package com.example.fitness_tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler extends RecyclerView.Adapter<recycler.holder> {
    ArrayList<bicep> model;


    public recycler(ArrayList<bicep> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list,parent,false);

        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.im.setImageResource(model.get(position).getId());
        holder.t1.setText(model.get(position).getHeading());
        holder.t2.setText(model.get(position).getBody());
        holder.play.setImageResource(model.get(position).get_btn());
        
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    class holder extends RecyclerView.ViewHolder{
        ImageView im;
        TextView t1;
        TextView t2;
        ImageView play;


        public holder(@NonNull View itemView) {
            super(itemView);


            im=itemView.findViewById(R.id.bicep100);
            t1=itemView.findViewById(R.id.textbicep1);
            t2=itemView.findViewById(R.id.text1);
            play=itemView.findViewById(R.id.workout_button);

        }
    }
}
