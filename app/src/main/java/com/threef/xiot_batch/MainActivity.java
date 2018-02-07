package com.threef.xiot_batch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(), "XIOT Batch started...", Toast.LENGTH_SHORT).show();
    }

    public void scheduleXiot( View m_view)
    {
        Toast.makeText(getApplicationContext(), "XIOT Batch to be scheduled...", Toast.LENGTH_LONG).show();

    }
}
