package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class EditRecord extends AppCompatActivity {

    private EditText dateedittext,timeedittext,sysedittext,diasedittext,hredittext,cmtedittext;
    private Button upload;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        dateedittext = findViewById(R.id.titleid);
        timeedittext = findViewById(R.id.descid);
        sysedittext = findViewById(R.id.systolicpressureid);
        diasedittext = findViewById(R.id.diastolicpressureid);
        hredittext = findViewById(R.id.heartrateid);
        cmtedittext = findViewById(R.id.commentid);

        upload = findViewById(R.id.uploadid);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String key = bundle.getString("key");
            String date = bundle.getString("date");
            String time = bundle.getString("time");
            String systolic = bundle.getString("sys");
            String diastolic = bundle.getString("dias");
            String heartrate = bundle.getString("hr");
            String comment = bundle.getString("cmt");

            dateedittext.setText(date);
            timeedittext.setText(time);
            sysedittext.setText(systolic);
            diasedittext.setText(diastolic);
            hredittext.setText(heartrate);
            cmtedittext.setText(comment);

            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String dateom, timeom, systolic, diastolic, heartrate, comment;
                    dateom = dateedittext.getText().toString().trim();
                    timeom = timeedittext.getText().toString().trim();
                    systolic = sysedittext.getText().toString().trim();
                    diastolic = diasedittext.getText().toString().trim();
                    heartrate = hredittext.getText().toString().trim();
                    comment = cmtedittext.getText().toString().trim();



                    if (dateom.equals("") || timeom.equals("") || systolic.equals("") || diastolic.equals("") || heartrate.equals("") || comment.equals("")) {
                        Toast.makeText(getApplicationContext(), "Provide information to all queries", Toast.LENGTH_SHORT).show();
                    } else {
                        Insert_Record insert_record = new Insert_Record(key,dateom, timeom, systolic, diastolic, heartrate, comment);

                        databaseReference = FirebaseDatabase.getInstance().getReference("Added Record");
                        //String key = databaseReference.child(FirebaseAuth.getInstance().getUid()).getKey();
                        databaseReference.child(FirebaseAuth.getInstance().getUid())
                                .child(key)
                                .setValue(insert_record)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        Toast.makeText(EditRecord.this, "Data Updated", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(EditRecord.this, "Try again", Toast.LENGTH_SHORT).show();
                                    }
                                });


                        Intent intent = new Intent(EditRecord.this,Home.class);
                        startActivity(intent);
                    }


                }
            });
        }
    }
}