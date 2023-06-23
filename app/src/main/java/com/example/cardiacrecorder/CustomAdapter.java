package com.example.cardiacrecorder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Insert_Record> {

    private Activity context;
    private List<Insert_Record> insert_records_list;

    public CustomAdapter(Activity context, List<Insert_Record> insert_records_list) {
        super(context, R.layout.sample, insert_records_list);
        this.context = context;
        this.insert_records_list = insert_records_list;
    }


    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample,null,true);

        Insert_Record insert_record = insert_records_list.get(position);

        TextView datetextview = view.findViewById(R.id.domid);
        TextView timetextview = view.findViewById(R.id.tomid);
        TextView systextview = view.findViewById(R.id.sysid);
        TextView diastextview = view.findViewById(R.id.diasid);
        TextView hrtextview = view.findViewById(R.id.hrid);
        TextView commenttextview = view.findViewById(R.id.commentid);

        datetextview.setText(insert_record.getDate_of_measurement());
        timetextview.setText(insert_record.getTime_of_measurement());
        systextview.setText(insert_record.getSystolic_ressure());
        diastextview.setText(insert_record.getDiastolic_pressure());
        hrtextview.setText(insert_record.getHeartrate());
        commenttextview.setText(insert_record.getComment());



        return view;

    }
}
