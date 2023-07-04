package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Insert_Record> {

    private Activity context;
    private List<Insert_Record> insert_records_list;

    public CustomAdapter(Activity context, List<Insert_Record> insert_records_list) {
        super(context, R.layout.sample, insert_records_list);
        this.context = context;
        this.insert_records_list = insert_records_list;
    }
    public int count()
    {
        return insert_records_list.size();
    }

    @SuppressLint("ResourceAsColor")
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

        String sys = insert_record.getSystolic_ressure();
        String dias = insert_record.getDiastolic_pressure();
        String hr = insert_record.getHeartrate();

        String sysnum = sys.replaceAll("[^0-9]", "");
        String diasnum = dias.replaceAll("[^0-9]", "");
        String hrate = hr.replaceAll("[^0-9]", "");

        int si = Integer.parseInt(sysnum);
        int di = Integer.parseInt(diasnum);
        int heartrate = Integer.parseInt(hrate);

        if (si < 60 || di > 140 || heartrate < 60) {
           // view.setBackgroundResource(R.drawable.danger2);
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.highlight_color));
        }
        else {
            //view.setBackgroundResource(0);
            view.setBackgroundColor(0);
        }
        return view;

    }
}
