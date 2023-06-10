package com.example.cardiacrecorder;

public class Insert_Record {

    private String date_of_measurement,time_of_measurement,systolic_ressure,diastolic_pressure,heartrate,comment;

    public Insert_Record(String date_of_measurement, String time_of_measurement, String systolic_ressure, String diastolic_pressure, String heartrate, String comment) {
        this.date_of_measurement = date_of_measurement;
        this.time_of_measurement = time_of_measurement;
        this.systolic_ressure = systolic_ressure;
        this.diastolic_pressure = diastolic_pressure;
        this.heartrate = heartrate;
        this.comment = comment;
    }

    public String getDate_of_measurement() {
        return date_of_measurement;
    }

    public void setDate_of_measurement(String date_of_measurement) {
        this.date_of_measurement = date_of_measurement;
    }

    public String getTime_of_measurement() {
        return time_of_measurement;
    }

    public void setTime_of_measurement(String time_of_measurement) {
        this.time_of_measurement = time_of_measurement;
    }

    public String getSystolic_ressure() {
        return systolic_ressure;
    }

    public void setSystolic_ressure(String systolic_ressure) {
        this.systolic_ressure = systolic_ressure;
    }

    public String getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public void setDiastolic_pressure(String diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
