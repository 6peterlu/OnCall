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
    public  float doctorRatio;
    public String doctorSpecialty;
    public String doctorInstitution;
    public int yearsOfExperience;
    public String accreditations;
    public String contact;


    public Person (String id, String doctorStatus , String doctorName,
                   String doctorFamily, String doctorPhoto, String institution, String specialty, float ratio,
                   int yearsOfExperience, String accreditations, String contact) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorFamily = doctorFamily;
        this.doctorStatus = doctorStatus;
        this.doctorPhoto = doctorPhoto;
        this.doctorInstitution =institution;
        this.doctorSpecialty = specialty;
        this.doctorRatio=ratio;

        this.doctorFullName = this.doctorStatus+" "+this.doctorName+" "+this.doctorFamily;
        this.yearsOfExperience = yearsOfExperience;
        this.accreditations = accreditations;
        this.contact = contact;
    }
    public Person parse(JSONObject json) {
        this.id = json.optString("id");
        this.doctorName = json.optString("name");
        this.doctorFamily = json.optString("family");
        this.doctorStatus = json.optString("status");
        this.doctorPhoto = json.optString("photoUrl");
        this.doctorRatio=(float) json.optDouble("ratio");
        this.doctorSpecialty =json.optString("spetialty");
        this.doctorInstitution =json.optString("intitution");
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
    public String getID() {
        return id;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public String getDoctorFamily() {
        return doctorFamily;
    }
    public String getDoctorPhoto() {
        return doctorPhoto;
    }
    public String getDoctorStatus() {
        return doctorStatus;
    }
    public String getDoctorFullName() {
        return doctorFullName;
    }
    public String getDoctorSpecialty() {
        return doctorSpecialty;
    }
    public String getDoctorInstitution() {
        return doctorInstitution;
    }
    public float getDoctorRatio(){
        return doctorRatio;
    }
    public int getYearsOfExperience(){
        return yearsOfExperience;
    }
    public String getAccreditations(){
        return accreditations;
    }
    public String getContact(){
        return contact;
    }
}
