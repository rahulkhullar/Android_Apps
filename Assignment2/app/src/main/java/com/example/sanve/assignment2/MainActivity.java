package com.example.sanve.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button displayMsg1,displayMsg2,btnLongRunOp;
    TextView txtOutputMsg;
    EditText inputText;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMsg1 = (Button) findViewById(R.id.displayMessageBtn1);
        displayMsg2 = (Button) findViewById(R.id.displayMessageBtn2);
        btnLongRunOp = (Button) findViewById(R.id.btnLongRunOperation);
        txtOutputMsg = (TextView) findViewById(R.id.textViewOut);
        inputText = (EditText) findViewById(R.id.editTextInput);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        inputText.setText("10000");
        displayMsg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Responding to button1 pressed on UIthread",Toast.LENGTH_LONG).show();

            }
        });
        displayMsg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Responding to button2 pressed on UIthread",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onClick(View v)
    {
        if(inputText == null)
        {
            //Toast.makeText(MainActivity.this,"Input field cannot be left blank!!",Toast.LENGTH_LONG).show();
            return;
        }
        else {

            final int inputValue = Integer.parseInt(inputText.getText().toString());
            progressBar.setVisibility(View.VISIBLE);
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
                        txtOutputMsg.post(new Runnable() {
                            @Override
                            public void run() {
                                txtOutputMsg.setText("Task progress");
                            }
                        });
                    }
                    txtOutputMsg.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            txtOutputMsg.setText("The long running task took " + inputValue + " mililiseconds");
                        }
                    });
                }
            });
            myWorkerThread.start();
        }
    }
}
