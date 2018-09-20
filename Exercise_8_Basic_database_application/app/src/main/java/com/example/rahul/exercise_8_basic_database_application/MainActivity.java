package com.example.rahul.exercise_8_basic_database_application;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name, name1;
        Boolean notFinished, notFinished1;
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        SQLiteDatabase db = openOrCreateDatabase("EmployeeDatabase", MODE_PRIVATE,
                null);

        db.execSQL("drop table if exists " + "EmployeeInformation");
//        db.execSQL("drop table if exists " + "Customer");

        db.execSQL("CREATE TABLE IF NOT EXISTS EmployeeInformation (LastName varchar, " +
                "FirstName varchar, PhoneNumber varchar, Address varchar, Position varchar);");

//        db.execSQL("CREATE TABLE IF NOT EXISTS Customer (LastName varchar, " +
//                "FirstName varchar, CustomerNumber varchar, Age varchar);");

        db.execSQL("INSERT INTO EmployeeInformation VALUES('Jones', 'Randy', '555-4325','Kingsville','Salesperson');");

        db.execSQL("INSERT INTO EmployeeInformation VALUES('Smith', 'Robert', '555-6789','Austin','Manager');");

        db.execSQL("INSERT INTO EmployeeInformation VALUES('Gracia', 'Roland',  '555-3456','San Antonio','Director');");

//        db.execSQL("INSERT INTO EmployeeInformation VALUES('Khullar', 'Rahul',  '5129862529','Bauhaus Bend, Austin');");
//
//        db.execSQL("INSERT INTO EmployeeInformation VALUES('Khullar', 'Hamant',  '5129865858','Batala, India');");
//
//        db.execSQL("INSERT INTO Customer VALUES('Khullar', 'Rahul',  '11028465','25');");
//
//        db.execSQL("INSERT INTO Customer VALUES('Khullar', 'Chetna',  '11028465','30');");

        Cursor cursor = db.rawQuery("SELECT * FROM EmployeeInformation", null);

//        Cursor cursor1 = db.rawQuery("SELECT * FROM Customer", null);

        notFinished = cursor.moveToFirst();
        tv1.setText("\n\n Database contents printed from loop processing are: \n");
        while (notFinished)
        {
            name = cursor.getString(cursor.getColumnIndex("LastName"))
                + ", " + cursor.getString(cursor.getColumnIndex("FirstName"))
                + "; " + cursor.getString(cursor.getColumnIndex("PhoneNumber"))
                + "; " + cursor.getString(cursor.getColumnIndex("Address"))
                    + "; " + cursor.getString(cursor.getColumnIndex("Position"));

            Log.d("result", name);
            tv1.append(name + "\n");
            notFinished = cursor.moveToNext();
        }

//        notFinished1 = cursor1.moveToFirst();
//        tv2.setText("\n\n Database contents printed from Customer table are: \n");
//        while (notFinished1)
//        {
//            name1 = cursor1.getString(cursor1.getColumnIndex("LastName"))
//                    + ", " + cursor1.getString(cursor1.getColumnIndex("FirstName"))
//                    + "; " + cursor1.getString(cursor1.getColumnIndex("CustomerNumber"))
//                    + "; " + cursor1.getString(cursor1.getColumnIndex("Age"));
//
//            Log.d("result", name1);
//            tv2.append(name1 + "\n");
//            notFinished1 = cursor1.moveToNext();
//        }

        db.close();
//        name = cursor.getString(cursor.getColumnIndex("LastName")) + ", "
//                + cursor.getString(cursor.getColumnIndex("FirstName"))
//                + ";" + cursor.getString(cursor.getColumnIndex("PhoneNumber"))
//                + ";" + cursor.getString(cursor.getColumnIndex("Address"));
//
//        Log.d("result", name);
//        tv1.setText("Database contents are: \n\n" + name + "\n");
//
//
//        cursor.moveToNext();
//
//        name = cursor.getString(cursor.getColumnIndex("LastName"))
//                + ", " + cursor.getString(cursor.getColumnIndex("FirstName"))
//                + "; " + cursor.getString(cursor.getColumnIndex("PhoneNumber"))
//                + "; " + cursor.getString(cursor.getColumnIndex("Address"));
//
//        Log.d("result", name);
//        tv1.append(name + "\n");
//
//
//        cursor.moveToNext();
//        name = cursor.getString(cursor.getColumnIndex("LastName"))
//                + ", " + cursor.getString(cursor.getColumnIndex("FirstName"))
//                + "; " + cursor.getString(cursor.getColumnIndex("PhoneNumber"))
//                + "; " + cursor.getString(cursor.getColumnIndex("Address"));
//
//        Log.d("result", name);
//        tv1.append(name);

//        db.close();

    }

}