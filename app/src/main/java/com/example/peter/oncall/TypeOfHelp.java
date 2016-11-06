package com.example.peter.oncall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class TypeOfHelp extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_help);
        categories = (ListView)findViewById(R.id.coarse_categories);
        ArrayList<String> catList = getCategoriesList();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, catList);
        categories.setAdapter(adapter);
        categories.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id){
        ArrayList<String> types;
        switch (position){
            case 1: Intent intent = new Intent(this, DetailedHelp.class);
                types = new ArrayList<>(Arrays.asList("Gastrointestinal", "General", "OBGYN", "Neurological",
                        "Cardiovascular", "Pediatrics", "Trauma", "Other"));
                intent.putStringArrayListExtra("types", types);
                intent.putExtra("title", "Surgery");
                startActivity(intent);
                break;
            default:
                //Continue to search list here?
        }
    }

    //Add items here!
    public ArrayList<String> getCategoriesList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Emergency Medicine");
        list.add("Surgery");
        list.add("Pre-Operation");
        list.add("Referrals and Transfers");
        return list;
    }
}
