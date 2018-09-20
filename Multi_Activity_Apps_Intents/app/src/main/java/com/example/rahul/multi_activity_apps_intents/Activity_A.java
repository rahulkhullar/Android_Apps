package com.example.rahul.multi_activity_apps_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Activity_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent_a = getIntent();
        String message = intent_a.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setText(" The message displayed with Activity A is: "+ message);
        setContentView(textView);
    }
}
