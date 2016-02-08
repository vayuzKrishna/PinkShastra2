package com.pinkshastra.vayuz.pinkshastra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Notification extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        String[] itemArray = {"You got a new case.                                                 21 jan 2016 07:27 pm","You have a pending prescription.                         18 jan 2016 05:27 pm","You have cancelled an appointment.                 17 jan 2016 06:27 pm","You have rescheduled an appointment.               15 jan 2016 07:27 pm","You have missed a case.                                      10 jan 2016 09:27 pm"};


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview,itemArray);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
