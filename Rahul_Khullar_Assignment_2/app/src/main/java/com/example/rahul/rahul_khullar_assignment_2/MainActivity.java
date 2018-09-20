package com.example.rahul.rahul_khullar_assignment_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity
{
    TextView textOutputMsg;
    EditText inputText;
    ProgressBar progressBar;
    Button displayMsg1,displayMsg2,btnLongRunOper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMsg1 = (Button) findViewById(R.id.displayMessage1);
        displayMsg2 = (Button) findViewById(R.id.displayMessage2);
        btnLongRunOper = (Button) findViewById(R.id.BtnLongRunOperation);
        textOutputMsg = (TextView) findViewById(R.id.textViewOut);
        inputText = (EditText) findViewById(R.id.TextInputEd);
        inputText.setText("10000");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        displayMsg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        Html.fromHtml("<strong>Responding to BTN1 pressed on UI thread</strong>"),
                        Toast.LENGTH_LONG).show();
            }
        });
        displayMsg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                Html.fromHtml("<strong>Responding to BTN2 pressed on UI thread</strong>"),
                Toast.LENGTH_LONG).show();
            }
        });

        btnLongRunOper.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputText.getText().toString()))
                {

                    Toast.makeText(MainActivity.this,
                    Html.fromHtml("<strong>ENTER VALID TIME IN INPUT FIELD</strong>"),
                    Toast.LENGTH_LONG).show();
                    return;
                }

                final int inputValue = Integer.parseInt(inputText.getText().toString());
            progressBar.setVisibility(View.VISIBLE);
            btnLongRunOper.setEnabled(false);
            Thread myWorkerThread = new Thread(new Runnable() {

                @Override
                public void run() {

                    for (int i = 0; i < 100; i++) {
                        progressBar.setProgress(i);
                        progressBar.setMax(100);
                        try {
                            Thread.sleep(inputValue / 100);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        textOutputMsg.post(new Runnable() {
                            @Override
                            public void run() {
                                textOutputMsg.setText("Task progress");
                            }
                        });
                    }
                    textOutputMsg.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            textOutputMsg.setText("The long running task took "
                                    + inputValue + " mililiseconds");
                            btnLongRunOper.setEnabled(true);
                        }
                    });

                }
            });
            myWorkerThread.start();

            }
        });

    }
}



