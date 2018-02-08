package com.threef.xiot_batch;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by Atul on 2/6/2018.
 */

public class UploadDataService extends JobService {
    private UploadDataSchedular dataLoaderProcess;

    @Override
    public boolean onStartJob(JobParameters params) {
        final JobParameters m_innerParams = params;
        dataLoaderProcess = new UploadDataSchedular(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
                jobFinished(m_innerParams , false);
            }
        };
        dataLoaderProcess.execute();
        return true; // separate thread for uploading
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        dataLoaderProcess.cancel(false);
        return false;
    }
}

