package com.pinkshastra.vayuz.pinkshastra.today;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pinkshastra.vayuz.pinkshastra.R;


public class CaseView extends AppCompatActivity implements View.OnClickListener{

    Button viewCase,cancle,reschedule;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_view);

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


        init();

    }

    public void init()
    {


        viewCase = (Button) findViewById(R.id.view_case_details);
        cancle = (Button) findViewById(R.id.cancle);
        reschedule = (Button) findViewById(R.id.reschedule);


        viewCase.setOnClickListener(this);
        cancle.setOnClickListener(this);
        reschedule.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.view_case_details:
                Intent intent = new Intent(CaseView.this,CasePreview.class);
                intent.putExtra("Tag","Prescribe");
                startActivity(intent);
                break;
            case R.id.cancle:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CaseView.this);


                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want to cancel the appointment ?");

                // Setting Icon to Dialog
                // alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        startActivity(new Intent(CaseView.this,CaseViewCancle.class));
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
                break;
            case R.id.reschedule:
                AlertDialog.Builder alertDialogr = new AlertDialog.Builder(CaseView.this);


                // Setting Dialog Message
                alertDialogr.setMessage("Are you sure you want to reschedule the appointment ?");

                // Setting Icon to Dialog
                // alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialogr.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        startActivity(new Intent(CaseView.this,CaseViewReschedule.class));
                    }
                });

                // Setting Negative "NO" Button
                alertDialogr.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialogr.show();
                break;
        }
    }
}
