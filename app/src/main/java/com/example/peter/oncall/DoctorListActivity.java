package com.example.peter.oncall;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Enuviel on 11/5/16.
 */


public class DoctorListActivity extends Activity {

    private static final String TAG = DoctorListActivity.class.getSimpleName();

    private ListView mListView;
    private BaseAdapter mDoctorsAdapter;
    private List<Person> mPersonList;

    private EditText mSearchTextEdit;
    private Button mBtnSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_list_activity);
        mListView = (ListView) findViewById(R.id.doctors_list);
        mPersonList = MainActivity.mPersonList;
        mBtnSearch = (Button) findViewById(R.id.btnSearch);
        mSearchTextEdit = (EditText) findViewById(R.id.searchText);

        mListView.setAdapter(mDoctorsAdapter = new BaseAdapter() {
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_convert, parent, false);
                }

                final Person person = mPersonList.get(position);

                ImageView imgPhoto = (ImageView) convertView.findViewById(R.id.doctor_photo);
                TextView txtName = (TextView) convertView.findViewById(R.id.list_convert_doctor_name);
                TextView txtSpecialty = (TextView) convertView.findViewById(R.id.list_convert_doctor_specialty);
                TextView txtInstitution = (TextView) convertView.findViewById(R.id.list_convet_doctor_institution);
                RatingBar rbRatio = (RatingBar) convertView.findViewById(R.id.ratingBar1);


                if (!TextUtils.isEmpty(person.doctorPhoto)) {
                    Glide.with(DoctorListActivity.this)
                            .load(person.doctorPhoto)
                            .centerCrop()
                            .crossFade()
                            .into(imgPhoto);
                } else {
                    imgPhoto.setImageDrawable(null);
                }
                txtName.setText(person.doctorFullName);
                txtInstitution.setText(person.doctorInstitution);
                txtSpecialty.setText(person.doctorSpecialty);
                rbRatio.setRating(person.doctorRatio);

                return convertView;

            }


            public long getItemId(int position) {
                return 0;
            }

            public Person getItem(int position) {
                return mPersonList.get(position);
            }

            public int getCount() {
                return mPersonList.size();
            }

        });

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> list = new ArrayList<>();
                mPersonList = MainActivity.mPersonList;

                for (Person p : mPersonList) {
                    if (p.doctorFullName.toLowerCase().contains(mSearchTextEdit.getText().toString().trim().toLowerCase())) {
                        list.add(p);
                    }
                }
                mPersonList = list;
                mDoctorsAdapter.notifyDataSetChanged();
            }
        });

        mSearchTextEdit.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (mSearchTextEdit.getText().toString().trim().length() == 0) {
                    mBtnSearch.setEnabled(false);
                    mPersonList = MainActivity.mPersonList;
                    mDoctorsAdapter.notifyDataSetChanged();
                } else {
                    mBtnSearch.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void afterTextChanged(Editable arg0) {

            }
        });


    }


}

