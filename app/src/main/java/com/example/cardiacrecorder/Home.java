package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private Button insertdatabutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        insertdatabutton = findViewById(R.id.insertdataid);

//        String uid = FirebaseAuth.getInstance().getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid);
        insertdatabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                if(bundle!=null)
                {
                    //String userid = bundle.getString("userId").trim();

                }
                Intent intent = new Intent(Home.this,Add_data.class);
                startActivity(intent);

            }
        });
    }
}