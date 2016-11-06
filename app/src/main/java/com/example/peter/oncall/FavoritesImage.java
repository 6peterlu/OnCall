package com.example.peter.oncall;

import org.json.JSONObject;

/**
 * Created by Peter on 11/5/2016.
 */
//help meeeeee
//copied straight out of your github
public class FavoritesImage {

    String imageSrc;
    String name;

    FavoritesImage parse(JSONObject json){
        this.imageSrc = json.optString("imageSrc");
        this.name = json.optString("name");
        return this;
    }
}
