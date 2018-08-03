package com.psspl.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.psspl.databindingdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> mArrayListUser = new ArrayList<>();
    private String[] fname = {"First name User 1", "First name User 2",
            "First name User 3", "First name User 4"};
    private String[] lname = {"Last name User 1", "Last name User 2",
            "Last name User 3", "Last name User 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This is binder which is bind to view.
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //setup recycler view and user without findview by id using @mainBinding
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this);
        mainBinding.recyclerView.setAdapter(mAdapter);

        //add data to arraylist
        for (int i = 0; i < fname.length; i++) {
            User mUser = new User();
            mUser.setFname(fname[i]);
            mUser.setLname(lname[i]);
            mArrayListUser.add(mUser);
        }

        mAdapter.setArrayListUser(mArrayListUser);


        /**
         * Added data in List view every 10 second
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < fname.length; i++) {
                    User mUser = new User();
                    mUser.setFname(fname[i]);
                    mUser.setLname(lname[i]);
                    mArrayListUser.add(mUser);
                }

                mAdapter.setArrayListUser(mArrayListUser);

            }
        }, 10000);
    }
}
