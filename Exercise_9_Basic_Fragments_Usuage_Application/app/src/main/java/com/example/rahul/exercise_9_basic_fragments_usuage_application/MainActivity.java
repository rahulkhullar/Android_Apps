package com.example.rahul.exercise_9_basic_fragments_usuage_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectFrag(View view)
    {
        Fragment fr;

        if(view == findViewById(R.id.button1))
        {
            fr = new activity_fragment_one();
        }
        else if (view == findViewById(R.id.button2))
        {
            fr = new activity_fragment_two();
        }
        else if (view == findViewById(R.id.button3))
        {
            fr = new activity_fragment_three();
        }
        else
        {
            fr = new activity_fragment_four();
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
    }
}
