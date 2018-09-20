package com.example.rahul.exercise_7_life_cycle_callback_methods_demonstrator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //    @Override
//    protected void onStop(Bundle savedInstanceState){
//        super.onStop();
//        Log.i("Hello","Stopped activity!");
//    }
    TextView textView1;
    final static String LOGCAT = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Log.d(LOGCAT,"apparently no bundle sent to onCreate() method");
        } else {
            Log.d(LOGCAT,"apparetly there was a Bundle sent to onCreate() method");
        }
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.append("\n in the onCreate() method Override ");
        Log.d(LOGCAT,"in the onCreate() Override");

    }
    @Override
    protected void onStart() {
        super.onStart();

        textView1.append( "\n in the onStart() method Override ");
        Log.d(LOGCAT,"in the onStart() Override");
    }
    @Override
    protected void onResume() {
        super.onResume();
        textView1.append("\n in the onResume() method Override ");
        Log.d(LOGCAT,"in the onRestart() Override");
    }
    @Override
    protected void onPause() {
        super.onPause();
        textView1.append("\n in the onPause() method Override ");
        Log.d(LOGCAT,"in the onPause() Override");
    }
    @Override
    protected void onStop() {
        super.onStop();
        textView1.append("\n in the onStop() method Override ");
        Log.d(LOGCAT,"in the onStop() Override");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        textView1.append("\n in the onRestart() method Override ");
        Log.d(LOGCAT,"in the onRestart() Override");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView1.append("\n in the onDestroy() method Override ");
        Log.d(LOGCAT,"in the onDestroy() Override");
    }

}
