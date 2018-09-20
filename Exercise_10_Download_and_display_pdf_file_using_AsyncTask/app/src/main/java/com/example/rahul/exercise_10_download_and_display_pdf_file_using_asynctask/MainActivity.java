package com.example.rahul.exercise_10_download_and_display_pdf_file_using_asynctask;

import java.io.File;
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;
import static android.support.v4.content.FileProvider.getUriForFile;
public class MainActivity extends Activity {
    public static File extStrgLoc = Environment.getExternalStorageDirectory();
    public static String fileName = "myfile.txt";
    public static File myFile = new File(extStrgLoc, fileName);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            toastIt("we do not have write permission!");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    0);
        }
    }
    public void download(View v){
        new DownloadFile().execute("http://www.pdf995.com/samples/pdf.pdf");
    }
    public void view(View v){
        // write your logic here to view the pdf
        Intent displayIntent = new Intent();
        displayIntent.setType("application/pdf");
        if(displayIntent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "no pdf viewer available to display file",
                    Toast.LENGTH_LONG).show();
        }
        else {
            displayIntent.setAction(Intent.ACTION_VIEW);
            Uri contentUri = getUriForFile(getBaseContext(),
                    "com.example.dlh.asyncdownloadpdf.fileprovider", myFile);
            displayIntent.setDataAndType(contentUri, "application/pdf");
            displayIntent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            displayIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(displayIntent);
        }
    }
    public void toastIt(String displayText) {
        Toast.makeText(this, displayText, Toast.LENGTH_LONG);
    }
    private class DownloadFile extends AsyncTask<String, Void, Void> {
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Downloading pdf");
            progressDialog.show();
        }
        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];
            FileDownloader.downloadFile(fileUrl, myFile);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(progressDialog != null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}