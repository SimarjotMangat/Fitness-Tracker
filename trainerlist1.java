package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class trainerlist1 extends AppCompatActivity implements adapterlist.Onphonelistner {
    RecyclerView recycle;
    ArrayList<model> datalist;
    FirebaseFirestore db;
    adapterlist adapterlist1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainerlist1);
        recycle=(RecyclerView)findViewById(R.id.recycleview1);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapterlist1=new adapterlist(datalist,this::onclicklistner);
        recycle.setAdapter(adapterlist1);


        db=FirebaseFirestore.getInstance();
        db.collection("trainer").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> list1=queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list1){


                    model obj=d.toObject(model.class);
                    datalist.add(obj);
                }
                adapterlist1.notifyDataSetChanged();

                //update adapter

            }
        });

    }

    @Override
    public void onclicklistner(int position) {
        String num=datalist.get(position).number;
        Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
        startActivity(i);




    }
}