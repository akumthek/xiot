package com.threef.xiot_batch;

import android.Manifest;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // for background processing of upload data
    private static final int JOB_UPLOAD_ID = 10037;
    private JobScheduler uploadJobSchedular;
    private JobInfo uploadJobInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(), "XIOT Batch started...", Toast.LENGTH_SHORT).show();
        ///checkRuntimePermission();

        // for background upload data

        ComponentName uploadComponentName = new ComponentName(this, UploadDataService.class);
        JobInfo.Builder uploadBuilder = new JobInfo.Builder(JOB_UPLOAD_ID, uploadComponentName);
        uploadBuilder.setPeriodic(10000);
        uploadBuilder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        uploadBuilder.setPersisted(true);
        uploadJobInfo = uploadBuilder.build();
        uploadJobSchedular = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);


    }

    public void startMe(View view)
    {
        uploadJobSchedular.schedule(uploadJobInfo);
        Toast.makeText(getApplicationContext(), "XIOT BATCH SCHEDULED...", Toast.LENGTH_LONG).show();

    }

    public void killMe(View view){
        //finsih();
        // stop background process
        uploadJobSchedular.cancel(JOB_UPLOAD_ID);
        Toast.makeText(getApplicationContext(), "background upload stopped...", Toast.LENGTH_LONG).show();

    }

    public void checkRuntimePermission(){
        final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 123;

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_SMS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_SMS,Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            }
        }
    }

}
