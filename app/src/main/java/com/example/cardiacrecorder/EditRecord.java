package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditRecord extends AppCompatActivity {

    private EditText dateedittext,timeedittext,sysedittext,diasedittext,hredittext,cmtedittext;
    private Button upload;
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
                    Intent intent = new Intent(EditRecord.this,Home.class);
                    startActivity(intent);
                }
            });
        }
    }
}