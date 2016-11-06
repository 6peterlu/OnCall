package com.example.peter.oncall;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Peter on 11/5/2016.
 */
public class FavoritePersonAdapter extends RecyclerView.Adapter<FavoritePersonAdapter.ViewHolder> {

    private List<FavoritesImage> imagesList;
    private Activity mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView1;
        private ImageView mImageView2;
        private ImageView mImageView3;

        private ViewHolder(View v) {
            super(v);
            mImageView1 = (ImageView) v.findViewById(R.id.image1);
            mImageView2 = (ImageView) v.findViewById(R.id.image2);
            mImageView3 = (ImageView) v.findViewById(R.id.image3);
        }
    }

    public FavoritePersonAdapter(List<FavoritesImage> imageList, Activity context) {
        this.imagesList = imageList;
        mContext = context;
    }

    @Override
    public FavoritePersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_button, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //I don't know what is going on :O

    }
    @Override
    public int getItemCount() {
        int result = imagesList.size() / 3;
        return result;
    }


}
