package com.example.rahul.basic_mathematical_operations_app;

//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
    EditText etNum1;
    Float numC;
    EditText etNum2;
    Button btnMult;
    Button btnAdd;
    TextView tvResult;
    String oper = "";
    Button btnCube;

// called when the activity is first created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the elements
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCube = (Button) findViewById(R.id.button3);
        btnCube.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Float result = Float.parseFloat(etNum1.getText().toString()) *
                        Float.parseFloat(etNum1.getText().toString()) *
                        Float.parseFloat(etNum1.getText().toString());
                tvResult.setText("Result of Cube of first number"+ " "+ result.toString());;
            }
        });
        // set a listener
        btnMult.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        //btnCube.setOnClickListener(this);
    }


        @Override
        public void onClick(View v)
        {
//          TODO auto generated method stub
         float num1 = 0;
         float num2 = 0;
         float result = 0;
         // check if fields are empty
         if (TextUtils.isEmpty(etNum1.getText().toString())
             || TextUtils.isEmpty(etNum2.getText().toString()))
            {
             return;

            }
         // read EditText and fill variables with numbers
         num1 = Float.parseFloat(etNum1.getText().toString());
         num2 = Float.parseFloat(etNum2.getText().toString());
         // defines the button that has been clicked and performs the corresponding operations
         // write operation into oper, we will use it latter for output
         switch (v.getId())
            {


             case R.id.btnMult:
                 oper = "*";
                 result = num1 * num2;
                 break;

                case R.id.btnAdd:
                    oper = "+";
                    result = num1 + num2;
                    break;
//                case R.id.button3:
//                    result = num1 * num1 * num1;
//                    break;
                default:
                    break;


            }

         // form the output line
            tvResult.setText("Result = " + result);

        }

    }

