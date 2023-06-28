package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_data extends AppCompatActivity {

    private Button uploadbutton;
    private EditText dom,tom,sysp,diasp,hr,cmt;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("Added Record");
        uploadbutton = findViewById(R.id.uploadid);

        dom = findViewById(R.id.titleid);
        tom = findViewById(R.id.descid);
        sysp = findViewById(R.id.systolicpressureid);
        diasp = findViewById(R.id.diastolicpressureid);
        hr = findViewById(R.id.heartrateid);
        cmt = findViewById(R.id.commentid);



        uploadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String key = databaseReference.push().getKey();

                String dateom, timeom, systolic, diastolic, heartrate, comment;
                dateom = dom.getText().toString().trim();
                timeom = tom.getText().toString().trim();
                systolic = sysp.getText().toString().trim();
                diastolic = diasp.getText().toString().trim();
                heartrate = hr.getText().toString().trim();
                comment = cmt.getText().toString().trim();

                if (dateom.equals("") || timeom.equals("") || systolic.equals("") || diastolic.equals("") || heartrate.equals("") || comment.equals("")) {
                    Toast.makeText(getApplicationContext(), "Provide information to all queries", Toast.LENGTH_SHORT).show();
                } else {
                    Insert_Record insert_record = new Insert_Record(key,dateom, timeom, systolic, diastolic, heartrate, comment);

                    String uid = FirebaseAuth.getInstance().getUid();
                    databaseReference.child(uid).child(key).setValue(insert_record);

                    Toast.makeText(getApplicationContext(), "New record inserted successfully", Toast.LENGTH_SHORT).show();

                    //Intent intent = new Intent(Add_data.this,Home.class);
                    // startActivity(intent);

                    dom.setText("");
                    tom.setText("");
                    sysp.setText("");
                    diasp.setText("");
                    hr.setText("");
                    cmt.setText("");

                    Intent intent = new Intent(Add_data.this, Home.class);
                    startActivity(intent);

                }
            }
        });
    }
}