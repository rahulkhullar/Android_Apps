package com.example.dhola.exercise3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addButton, subtractButton, resetButton;
    TextView tv1;
    EditText scoreText;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        scoreText = (EditText) findViewById(R.id.editText);
        tv1 = (TextView) findViewById(R.id.myTextTitle);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (scoreText.getText().toString().isEmpty()) {
                    x = 0;
                    scoreText.setText(Integer.toString(x));
                    scoreText.setBackgroundColor(Color.MAGENTA);
                } else {
                    String textNumber = scoreText.getText().toString();
                    x = Integer.valueOf(textNumber);
                    x++;
                    scoreText.setText(Integer.toString(x));
                    scoreText.setBackgroundColor(Color.CYAN);
                }
            }
        });

        subtractButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (scoreText.getText().toString().isEmpty()) {
            x = 0;
            scoreText.setText(Integer.toString(x));
            scoreText.setBackgroundColor(Color.MAGENTA);
        }
        else {
            String textNumber = scoreText.getText().toString();
            x = Integer.valueOf(textNumber);

            if (v == subtractButton) {
                x--;
                scoreText.setText(Integer.toString(x));
                scoreText.setBackgroundColor(Color.RED);
            }
        }
    }

    public void reset(View v) {
        if (scoreText.getText().toString().isEmpty()) {
            x = 0;
            scoreText.setText(Integer.toString(x));
            scoreText.setBackgroundColor(Color.MAGENTA);
        } else {
            String textNumber = scoreText.getText().toString();
            x = Integer.valueOf(textNumber);
            if (v == resetButton) {
                x = 0;
                scoreText.setText(Integer.toString(x));
                scoreText.setBackgroundColor(Color.YELLOW);
            }
        }
    }

}


