package com.example.peter.oncall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent incoming = getIntent();
        if(incoming.hasExtra("name")){
            TextView name = (TextView) findViewById(R.id.name);
            name.setText(incoming.getStringExtra("name"));
        }
        if(incoming.hasExtra("specialty")){
            TextView specialty = (TextView)findViewById(R.id.specialty);
            specialty.setText(incoming.getStringExtra("specialty"));
        }
        if(incoming.hasExtra("rating")){
            RatingBar rb = (RatingBar)findViewById(R.id.ratingBar1);
            rb.setRating(incoming.getFloatExtra("rating", 0f));
        }
        if(incoming.hasExtra("experience")){
            TextView experience = (TextView)findViewById(R.id.experience);
            experience.setText(""+incoming.getIntExtra("experience", 0));
        }
        if(incoming.hasExtra("accreditations")){
            TextView experience = (TextView)findViewById(R.id.accreditations);
            experience.setText(incoming.getStringExtra("accreditations"));
        }
        if(incoming.hasExtra("contact")){
            TextView contact = (TextView)findViewById(R.id.contact);
            contact.setText(incoming.getStringExtra("contact"));
        }
        if(incoming.hasExtra("photo")){
            ImageView pic = (ImageView)findViewById(R.id.profile_image);
            String url = incoming.getStringExtra("photo");
            if (!TextUtils.isEmpty(url)) {
                Glide.with(ProfileActivity.this)
                        .load(url)
                        .centerCrop()
                        .crossFade()
                        .into(pic);
            } else {
                pic.setImageDrawable(null);
            }
        }
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }
}
