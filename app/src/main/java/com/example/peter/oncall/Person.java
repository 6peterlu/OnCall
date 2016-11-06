package com.example.peter.oncall;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Created by Enuviel on 11/5/16.
 */
public class Person {
    private static final String TAG = Person.class.getSimpleName();

    public String id;
    public String doctorName;
    public String doctorFamily;
    public String doctorPhoto;
    public String doctorStatus;
    public String[] topicsIds;
    public String doctorFullName;


    public Person (String id, String doctorStatus ,String doctorName,
                   String doctorFamily,String doctorPhoto) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorFamily = doctorFamily;
        this.doctorStatus = doctorStatus;
        this.doctorPhoto = doctorPhoto;
        this.doctorFullName = this.doctorStatus+" "+this.doctorName+" "+this.doctorFamily;
    }
    public Person parse(JSONObject json) {
        this.id = json.optString("id");
        this.doctorName = json.optString("name");
        this.doctorFamily = json.optString("family");
        this.doctorStatus = json.optString("status");
        this.doctorPhoto = json.optString("photoUrl");
        this.doctorFullName = this.doctorStatus+" "+this.doctorName+" "+this.doctorFamily;
        JSONArray array = json.optJSONArray("topicsIds");
        try {
            this.topicsIds = new String[array.length()];
            for (int i = 0; i < array.length(); i++) {
                this.topicsIds[i] = array.getString(i);
            }
        } catch (Exception e) {
            Log.e(TAG, "Cannot parse JSON", e);
        }
        return this;
    }

}
