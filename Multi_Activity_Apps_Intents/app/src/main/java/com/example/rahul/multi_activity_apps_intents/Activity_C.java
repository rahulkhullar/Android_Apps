package com.example.rahul.multi_activity_apps_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent_c = getIntent();
        String message = intent_c.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setText(" The message displayed with Activity C is: "+ message);
        setContentView(textView);
    }
}
