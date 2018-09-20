package com.example.rahul.assignment_1_calculator_rahul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;


public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText EditText;
    String operator = null;


    float ValueOne, ValueTwo;
    int count1 = 0;

    boolean mAddition = false;
    boolean mSubtract = false;
    boolean mMultiplication = false;
    boolean mDivision = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDivision = (Button) findViewById(R.id.buttonDiv);
        buttonC = (Button) findViewById(R.id.buttonCLR);
        buttonEqual = (Button) findViewById(R.id.buttonEql);
        EditText = (EditText) findViewById(R.id.edit);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText.setText(EditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (TextUtils.isEmpty(EditText.getText().toString()))
                {

                    return;
                }
                else
                    {

                    ValueOne = Float.parseFloat(EditText.getText() + "");
                    mAddition = true;
                    operator = "+";
                    EditText.setText(EditText.getText() + operator);


                    }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(EditText.getText().toString()))
                {
                    return;
                }
                else
                    {
                    ValueOne = Float.parseFloat(EditText.getText() + "");
                    mSubtract = true;
                    operator = "-";
                    EditText.setText(EditText.getText() + operator);
                    }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(EditText.getText().toString()))
                {
                    return;
                }
                else
                    {
                    ValueOne = Float.parseFloat(EditText.getText() + "");
                    mMultiplication = true;
                    operator = "*";
                    EditText.setText(EditText.getText() + operator);
                    }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(EditText.getText().toString()))
                {
                    return;
                }
                else
                    {
                    ValueOne = Float.parseFloat(EditText.getText() + "");
                    mDivision = true;
                    operator = "/";
                    EditText.setText(EditText.getText() + operator);
                    }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int oprPosition = EditText.getText().toString().indexOf(operator)+1;

                if (TextUtils.isEmpty(EditText.getText().toString()))
                {
                    return;
                }

                else
                    {

                        int oprPosition = EditText.getText().toString().indexOf(operator)+1;
                        ValueTwo = Float.parseFloat
                        ((EditText.getText()).toString().substring(oprPosition));

                        float result = 0;
                        if (mAddition)
                        {
                        result = ValueOne + ValueTwo;
                        mAddition = false;
                        }

                        if (mSubtract)
                        {
                        result = ValueOne - ValueTwo;
                        mSubtract = false;
                        }

                        if (mMultiplication)
                        {
                        result = ValueOne * ValueTwo;
                        mMultiplication = false;
                        }

                        if (mDivision)
                        {
                        result = ValueOne / ValueTwo;
                        mDivision = false;
                        }
                        EditText.setText( String.valueOf(result) + "");

                    }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + ".");
            }
        });
    }
}