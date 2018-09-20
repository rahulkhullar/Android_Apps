package com.example.rahul.print_name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText editText3;
    private EditText editText;
    private TextView result;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText3 = (EditText) findViewById(R.id.editText3);
        result = (TextView) findViewById(R.id.textView);

        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.textView);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result.setText("Welcome" + "  "+ editText.getText() +" "+ editText3.getText() +"  "+ "K00428791");

            }
        });

    }
}
