package com.example.peter.oncall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


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
            listItems = incoming.getStringArrayListExtra("types");
        }
        TextView tv = (TextView) findViewById(R.id.list_title);
        tv.setText(title);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        types.setAdapter(adapter);
    }

}
