package com.example.fitness_tracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class  addtrainer extends AppCompatActivity {
    ImageView addimage;
    String name,address,phoneno,email;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    FirebaseFirestore db;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrainer);
        RadioButton r1=(RadioButton)findViewById(R.id.radio1);
        RadioButton r2=(RadioButton)findViewById(R.id.radio2);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setChecked(true);
                r2.setChecked(false);

            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setChecked(false);
                r2.setChecked(true);

            }
        });




       addimage=(ImageView)findViewById(R.id.addimage1);
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,1);
            }
        });

        Button b1=(Button)findViewById(R.id.addtrainer_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1=(EditText)findViewById(R.id.trainername);
                EditText t2=(EditText)findViewById(R.id.Traineraddress);
                EditText t3=(EditText)findViewById(R.id.Trainerphone);
                EditText t4=(EditText)findViewById(R.id.Traineremail);
                name= t1.getText().toString().trim();
                address=t2.getText().toString().trim();
               phoneno= t3.getText().toString().trim();
                email=t4.getText().toString().trim();

               if(!name.isEmpty()&&!address.isEmpty()&&!phoneno.isEmpty()&&!email.isEmpty()){
                   db=FirebaseFirestore.getInstance();
                   CollectionReference cb=db.collection("trainer");
                   User use=new User(name,phoneno,address,email);
                   cb.add(use).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                       @Override
                       public void onSuccess(DocumentReference documentReference) {
                           t1.setText("");
                           t2.setText("");
                           t3.setText("");
                           t4.setText("");
                           Toast.makeText(getApplicationContext(),"trainer added",Toast.LENGTH_LONG).show();
                           Intent i=new Intent(addtrainer.this,listtrainer.class);
                           i.putExtra("address",address);
                           i.putExtra("name",name);
                           i.putExtra("phoneno",phoneno);
                           i.putExtra("email",email);
                           startActivity(i);

                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(getApplicationContext(),"trainer not added"+e,Toast.LENGTH_LONG).show();


                       }
                   });



               }
               else{

                   Toast.makeText(getApplicationContext(),"Please Fill all the details",Toast.LENGTH_LONG).show();
               }








            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            addimage.setImageBitmap(imageBitmap);

        }

    }
}
