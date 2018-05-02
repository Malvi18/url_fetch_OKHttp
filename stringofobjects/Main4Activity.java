package com.example.android_job_project.stringofobjects;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android_job_project.R;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Fragment fragment=new BlankFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame,fragment).commit();
    }
}
