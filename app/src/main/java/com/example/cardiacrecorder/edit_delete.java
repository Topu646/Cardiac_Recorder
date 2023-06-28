package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
//import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class edit_delete extends AppCompatActivity {

    private TextView dateview,timeview,systolicview,diastolicview,heartview,commentview;
    private Button edit,delete;
    DatabaseReference databaseReference;
    private String key,date,time,systolic_Pressure,diastolic_Pressure,heart_rate,comment;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        dateview = findViewById(R.id.datetextView);
        timeview = findViewById(R.id.timetextView);
        systolicview = findViewById(R.id.systolictextview);
        diastolicview = findViewById(R.id.diastolicpressuretextview);
        heartview = findViewById(R.id.heartratetextview);
        commentview = findViewById(R.id.commenttextview);

        edit = findViewById(R.id.editbutton);
        delete = findViewById(R.id.deletebutton);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
             key = bundle.getString("key");
             date = bundle.getString("date");
             time = bundle.getString("time");
             systolic_Pressure = bundle.getString("systolic");
             diastolic_Pressure = bundle.getString("diastolic");
             heart_rate = bundle.getString("heartrate");
             comment = bundle.getString("comment");
        }

        dateview.setText("Date of mesurement : "+date);
        timeview.setText("Time of mesurement : "+time);
        systolicview.setText("Systolic Pressure : "+systolic_Pressure);
        diastolicview.setText("Diastolic Pressure : "+diastolic_Pressure);
        heartview.setText("Heart Rate : "+heart_rate);
        commentview.setText("Comment : "+comment);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference = FirebaseDatabase.getInstance().getReference("Added Record");
                //String key = databaseReference.child(FirebaseAuth.getInstance().getUid()).getKey();
                databaseReference.child(FirebaseAuth.getInstance().getUid())
                        .child(key)
                        .removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                Toast.makeText(edit_delete.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(edit_delete.this, "Try again", Toast.LENGTH_SHORT).show();
                            }
                        });

                Intent intent = new Intent(edit_delete.this,Home.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_delete.this,EditRecord.class);

                intent.putExtra("key",key);
                intent.putExtra("date",date);
                intent.putExtra("time",time);
                intent.putExtra("sys",systolic_Pressure);
                intent.putExtra("dias",diastolic_Pressure);
                intent.putExtra("hr",heart_rate);
                intent.putExtra("cmt",comment);

                startActivity(intent);
            }
        });
    }
}