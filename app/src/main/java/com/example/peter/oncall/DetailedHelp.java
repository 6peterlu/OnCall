package com.example.peter.oncall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class DetailedHelp extends AppCompatActivity {

    private ListView types;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_help);
        Intent incoming = getIntent();
        String title = "title not set";
        ArrayList<String> listItems = new ArrayList<>();
        listItems.add("test");
        types = (ListView) findViewById(R.id.fine_categories);
        if (incoming.hasExtra("title")) {
            title = incoming.getStringExtra("title");
        }
        if (incoming.hasExtra("types")) {
            Log.d("hi", "incoming has str arraylist extra");
            listItems = incoming.getStringArrayListExtra("types");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        types.setAdapter(adapter);
    }

}
