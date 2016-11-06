package com.example.peter.oncall;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.peter.oncall.R.styleable.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private List<Person> mPersonList = new ArrayList<>();
    private FavoritePersonAdapter mFavoritePersonAdapter;
    private RecyclerView mRvImages;
    private Button buttonClick;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick = (Button) findViewById(R.id.search);
        buttonClick.setOnClickListener(this);
        createListOfPersons();
        mFavoritePersonAdapter = new FavoritePersonAdapter(mPersonList, MainActivity.this);
        final LinearLayoutManager llManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvImages = (RecyclerView) findViewById(R.id.recycleFavorites);
        mRvImages.setLayoutManager(llManager);
        mRvImages.setAdapter(mFavoritePersonAdapter);

    }

    public void onClick(View view){
        if(view == buttonClick){
            Intent intent = new Intent(this, DoctorListActivity.class);
            startActivity(intent);
        }
    }
    public void createListOfPersons() {
        Person anna=new Person("1","Dr.","Anna","Orlova","");
        Person peter=new Person("2","MD","Peter","Lu","");
        Person mike=new Person("3","MD","Mike","Hittle","");
        Person annie=new Person("3","MD","Annie","Brantigan","");
        Person james = new Person("4", "MD", "James", "Wall", "");
        Person jeremy = new Person("5", "PhD", "Jeremy", "Hammer", "");
        Person michelle = new Person("6", "MD", "Michelle", "Essien", "");
        Person anthony = new Person("7", "MD", "Anthony", "Agbay", "");
        mPersonList.add(anna);
        mPersonList.add(peter);
        mPersonList.add(mike);
        mPersonList.add(annie);
        mPersonList.add(jeremy);
        mPersonList.add(michelle);
        mPersonList.add(anthony);
        mPersonList.add(james);

    }

}
