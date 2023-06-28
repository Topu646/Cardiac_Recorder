package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private TextView emptytext;
    private Button insertdatabutton;
    private ListView listView;
    DatabaseReference databaseReference;
    List<Insert_Record> insert_recordList;
    CustomAdapter customAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        insert_recordList = new ArrayList<>();
        customAdapter = new CustomAdapter(Home.this,insert_recordList);

        emptytext = findViewById(R.id.emptytextid);
        listView = findViewById(R.id.listviewid);
        insertdatabutton = findViewById(R.id.insertdataid);
     //   String key = databaseReference.push().getKey();
        String uid = FirebaseAuth.getInstance().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Added Record").child(uid);

//        String uid = FirebaseAuth.getInstance().getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid);
        insertdatabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = getIntent().getExtras();
//                if(bundle!=null)
//                {
//                    //String userid = bundle.getString("userId").trim();
//
//                }
                Intent intent = new Intent(Home.this,Add_data.class);
                startActivity(intent);

            }
        });
    }


    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                insert_recordList.clear();

                if(snapshot.getChildrenCount() == 0)
                {
                    emptytext.setText("No available record to show");
                }
                else{
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                        Insert_Record record = dataSnapshot1.getValue(Insert_Record.class);
                        insert_recordList.add(record);

                    }
                    listView.setAdapter(customAdapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            String date = String.valueOf(insert_recordList.get(position).getDate_of_measurement());
                            String time  = String.valueOf(insert_recordList.get(position).getTime_of_measurement());
                            String systolicpre  = String.valueOf(insert_recordList.get(position).getSystolic_ressure());
                            String diastolicpre  = String.valueOf(insert_recordList.get(position).getDiastolic_pressure());
                            String heartr  = String.valueOf(insert_recordList.get(position).getHeartrate());
                            String commemts = String.valueOf(insert_recordList.get(position).getComment());


                            Toast.makeText(getApplicationContext(),diastolicpre,Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Home.this,edit_delete.class);
                            intent.putExtra("date",date);
                            intent.putExtra("time",time);
                            intent.putExtra("systolic",systolicpre);
                            intent.putExtra("diastolic",diastolicpre);
                            intent.putExtra("heartrate",heartr);
                            intent.putExtra("comment",commemts);

                            startActivity(intent);
                        }
                    });
                }



//                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}