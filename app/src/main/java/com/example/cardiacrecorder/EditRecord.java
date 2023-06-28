package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditRecord extends AppCompatActivity {

    private EditText dateedittext,timeedittext,sysedittext,diasedittext,hredittext,cmtedittext;
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
        }
    }
}