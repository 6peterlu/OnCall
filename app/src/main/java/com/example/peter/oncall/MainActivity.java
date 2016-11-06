package com.example.peter.oncall;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    public static List<Person> mPersonList = new ArrayList<>();
    private FavoritePersonAdapter mFavoritePersonAdapter;
    private RecyclerView mRvImages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createListOfPersons();
        mFavoritePersonAdapter = new FavoritePersonAdapter(mPersonList, MainActivity.this);
        final LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvImages = (RecyclerView) findViewById(R.id.recycleFavorites);
        mRvImages.setLayoutManager(llManager);
        mRvImages.setAdapter(mFavoritePersonAdapter);
        Button btnSearch = (Button) findViewById(R.id.buttonSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DoctorListActivity.class);
                startActivity(intent);

            }
        });
        Button btnCategories = (Button) findViewById(R.id.categories);
        btnCategories.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), TypeOfHelp.class);
                startActivity(intent);
            }
        });

    }

    public void createListOfPersons() {
        Person james = new Person("10", "MD", "James", "Wall", "https://cap.stanford.edu/profiles/viewImage?profileId=40307&type=square", "Stanford University", "Pediatric Surgery", 5f, 30, "No Accreditations", "example@gmail.com");
        Person annie = new Person("5", "MD", "Annie", "Brantigan", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAemAAAAJDc1ZWZmMmUzLTNhNTEtNDk5Yi04ZjRiLWU4NWE2YTI3MWZjZQ.jpg", "Stanford University", "General Surgery", 5f, 5, "No Accreditations", "example@gmail.com");
        Person peter = new Person("2", "MD", "Peter", "Lu", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAVLAAAAJDY2YjExYjVlLWJhZmYtNGNiZC04MjgzLTc5YTcxNjE1NWRkNg.jpg", "Stanford University", "Head and Neck Surgery", 4.5f, 7, "No Accreditations", "example@gmail.com");
        Person jeremy = new Person("6", "MD", "Jeremy", "Hammer", "https://media.licdn.com/media/AAEAAQAAAAAAAAJ6AAAAJDIyNmNmMWI2LTQzNDctNDk0Yi05YzBmLTJjMWQwNDI3MGZjMA.jpg", "Berkeley University", "General Surgery", 4.1f, 12, "No Accreditations", "example@gmail.com");
        Person mike = new Person("3", "MD", "Mike", "Hittle", "https://media.licdn.com/media/p/4/000/179/0c5/21f846c.jpg", "Stanford University", "General Surgery", 4f, 4, "No Accreditations", "example@gmail.com");
        Person anna = new Person("1", "Dr.", "Anna", "Orlova", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAMHAAAAJDgzN2JjY2IyLTYyYjMtNDRiYi04N2YxLWViMDdiNzM0MzE0NA.jpg", "Self Employed", "Surgery", 0f, 6, "No Accreditations", "example@gmail.com");
        Person michelle = new Person("9", "MD", "Michelle", "Essien", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAiYAAAAJGY4YzM1MzViLTE5M2EtNGQxZi1hNzQyLTA2ZmU5ZDM1Yjk3Yg.jpg", "Stanford University", "General Surgery", 0f, 40, "No Accreditations", "example@gmail.com");
        Person anthony = new Person("8", "MD", "Anthony", "Agbay", "https://media.licdn.com/media/p/6/005/079/1eb/03d7235.jpg", "Stanford University", "Head and Neck Surgery", 0f, 16, "No Accreditations", "example@gmail.com");
        mPersonList.add(james);
        mPersonList.add(annie);
        mPersonList.add(peter);
        mPersonList.add(jeremy);
        mPersonList.add(mike);
        mPersonList.add(anna);
        mPersonList.add(michelle);
        mPersonList.add(anthony);

    }

}
