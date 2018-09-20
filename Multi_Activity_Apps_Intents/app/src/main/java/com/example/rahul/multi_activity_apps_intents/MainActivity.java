package com.example.rahul.multi_activity_apps_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "Exercise4-message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // called when the user clicks the send button
    public void sendMessageFromIntent1(View view)
    {
      Intent intent = new Intent(this, Activity_A.class);
      EditText editText = (EditText) findViewById(R.id.edit_message);
      String message = editText.getText().toString();
      intent.putExtra(EXTRA_MESSAGE,message);
      startActivity(intent);

    }

    public void sendMessageFromIntent2(View view)
    {
        Intent intent = new Intent(this, Activity_B.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }
    public void sendMessageFromIntent3(View view)
    {
        Intent intent = new Intent(this, Activity_C.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }
}
