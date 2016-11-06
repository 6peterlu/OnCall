package com.example.peter.oncall;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

/**
 * Created by Peter on 11/5/2016.
 */
public class FavoritePersonAdapter extends RecyclerView.Adapter<FavoritePersonAdapter.ViewHolder> {

    private List<Person> mPersonList;
    private Activity mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView1;
        private TextView mNameView;


        private ViewHolder(View v) {
            super(v);
            mImageView1 = (ImageView) v.findViewById(R.id.profile_image);
            mNameView=(TextView) v.findViewById(R.id.profile_name);

        }
    }

    public FavoritePersonAdapter(List<Person> imageList, Activity context) {
        this.mPersonList = imageList;
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
        final Person person = mPersonList.get(position);
        if (!TextUtils.isEmpty(person.doctorPhoto)) {

            Glide.with(mContext)
                    .load(mPersonList.get(position).doctorPhoto)
                    .centerCrop()
                    .crossFade()
                    .into(holder.mImageView1);
        } else {

            Glide.clear(holder.mImageView1);
        }
        holder.mNameView.setText(person.doctorFullName);
    }
    @Override
    public int getItemCount() {

        return mPersonList.size();
    }


}
