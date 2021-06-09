package com.example.fitness_tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterlist extends RecyclerView.Adapter<adapterlist.viewholder1> {
    ArrayList<model> datalist;
    public Onphonelistner onphonelistner;

    public adapterlist(ArrayList<model> datalist,Onphonelistner onphonelistner) {
        this.datalist = datalist;
        this.onphonelistner=onphonelistner;
    }

    @NonNull
    @Override
    public viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.trainerlayout,parent,false);


        return new viewholder1(view,onphonelistner);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder1 holder, int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getAddress());
        holder.t3.setText(datalist.get(position).getNumber());
        holder.t4.setText(datalist.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class viewholder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1,t2,t3,t4;
        ImageView imageView;
        Onphonelistner onphonelistner;

        public viewholder1(@NonNull View itemView,Onphonelistner onphonelistner) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.i1);
            t1=(TextView)itemView.findViewById(R.id.n1);
            t2=(TextView)itemView.findViewById(R.id.a1);
            t3=(TextView)itemView.findViewById(R.id.p1);
            t4=(TextView)itemView.findViewById(R.id.e1);
            this.onphonelistner=onphonelistner;
            itemView.setOnClickListener(this);




        }


        @Override
        public void onClick(View view) {
            onphonelistner.onclicklistner(getAdapterPosition());

        }
    }

    public interface Onphonelistner{
        void onclicklistner(int position);
    }
}
