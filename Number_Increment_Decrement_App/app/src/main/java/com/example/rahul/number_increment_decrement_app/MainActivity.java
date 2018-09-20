package com.example.rahul.number_increment_decrement_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button addButton, subtractButton, resetButton;
    TextView tv1;
    EditText scoreText;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    addButton = (Button) findViewById(R.id.addButton);
    addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             {
                 String textNumber = scoreText.getText().toString();
                 if(textNumber.isEmpty()) {
                     x = 0;
                     scoreText.setText(Integer.toString(x));
                 }
                 else {
                     x = Integer.valueOf(textNumber);
                 }
                 String textNumber1 = scoreText.getText().toString();
                 x= Integer.valueOf(textNumber1);
                 x++;

            scoreText.setText(Integer.toString(x));
            scoreText.setBackgroundColor(Color.CYAN);

        }

        }
                                 }


    );
    subtractButton = (Button) findViewById(R.id.subtractButton);
    resetButton = (Button) findViewById(R.id.resetButton);
    scoreText = (EditText) findViewById(R.id.editText);
    tv1 = (TextView) findViewById(R.id.myTextTitle);

    //set on click listners for the buttons
//    addButton.setOnClickListener(this);
    subtractButton.setOnClickListener(this);
    resetButton.setOnClickListener(this);



    }
    @Override
    public void onClick (View v) {

        String textNumber = scoreText.getText().toString();
        if(textNumber.isEmpty()) {
            x = 0;
        }
        else {
            x = Integer.valueOf(textNumber);
        }



//        if(v == addButton) {
//            x++;
//            scoreText.setText(Integer.toString(x));
//            scoreText.setBackgroundColor(Color.CYAN);
//
//        }
        if(v == subtractButton) {
            x--;
            scoreText.setText(Integer.toString(x));
            scoreText.setBackgroundColor(Color.CYAN);
        }
        if(v == resetButton) {
            x = 0;
            scoreText.setText(Integer.toString(x));
            scoreText.setBackgroundColor(Color.YELLOW);

        }
    }
}
