package com.example.rahul.shared_preferences_exercise_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    EditText editText1;
    Button button1;
    RadioButton radioButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);

        editText1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.saveButton);
        loadSavedPreferences();

    }
    private void loadSavedPreferences()
    {
        SharedPreferences sharedPrefs =
        PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue1 = sharedPrefs.getBoolean("graphicsCoProc", true);
        boolean checkBoxValue2 = sharedPrefs.getBoolean("extendedMemory", false);
        boolean checkBoxValue3 = sharedPrefs.getBoolean("touchScreen", false);
        boolean checkBoxValue4 = sharedPrefs.getBoolean("highSpeedNetworkAdaptor",false);
        boolean radioButtonValue1 = sharedPrefs.getBoolean("defaultSetting",false);
        String memSize = sharedPrefs.getString("RAMCapacity", "2.5");
        if(checkBoxValue1)
        {
            checkBox1.setChecked(true);
        }
        else
        {
            checkBox1.setChecked(false);
        }
        if(checkBoxValue2)
        {
            checkBox2.setChecked(true);
        }
        else
            {
               checkBox2.setChecked(false);
            }
        if(checkBoxValue3)
        {
            checkBox3.setChecked(true);
        }
        else
        {
            checkBox3.setChecked(false);
        }
        if(checkBoxValue4)
        {
            checkBox4.setChecked(true);
        }
        else
        {
            checkBox4.setChecked(false);
        }
        editText1.setText(memSize);
        if(radioButtonValue1)
        {
            radioButton1.toggle();
        }
        else
        {
            radioButton1.toggle();
        }

    }
    private void savePreferences(String key, boolean value)
    {
        SharedPreferences sharedPrefs =PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean(key, value);
        // editor commit
        editor.apply();
    }
    private void savePreferences(String key, String value)
    {
        SharedPreferences sharedPrefs =PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(key, value);
        // editor commit
        editor.apply();
    }
    public void saveValues(View v)
    {
        savePreferences("graphicsCoProc", checkBox1.isChecked());
        savePreferences("extendedMemory", checkBox2.isChecked());
        savePreferences("touchScreen", checkBox3.isChecked());
        savePreferences("highSpeedNetworkAdaptor", checkBox4.isChecked());
        savePreferences("RAMCapacity", editText1.getText().toString());
        savePreferences("defaultSetting",radioButton1.isEnabled());

    }
    public void exitApp(View v)
    {
        finish();
    }


}
