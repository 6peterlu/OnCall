package com.example.peter.oncall;

import android.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private List<Person> mPersonList = new ArrayList<>();
    private FavoritePersonAdapter mFavoritePersonAdapter;
    private RecyclerView mRvImages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListOfPersons();
        mFavoritePersonAdapter = new FavoritePersonAdapter(mPersonList, MainActivity.this);
        final LinearLayoutManager llManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvImages = (RecyclerView) findViewById(R.id.recycleFavorites);
        mRvImages.setLayoutManager(llManager);
        mRvImages.setAdapter(mFavoritePersonAdapter);

    }

    public void createListOfPersons() {
        Person anna=new Person("1","Dr.","Anna","Orlova","");
        Person peter=new Person("2","MD","Peter","Lu","");
        Person mike=new Person("3","MD","Mike","Hittle","");
        mPersonList.add(anna);
        mPersonList.add(peter);
        mPersonList.add(mike);
    }

}
