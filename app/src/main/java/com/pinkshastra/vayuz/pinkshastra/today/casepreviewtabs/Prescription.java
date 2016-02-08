package com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.today.AddMed;

import java.util.Calendar;

public class Prescription extends AppCompatActivity {

    Toolbar toolbar;
    Button submit,hairfall;
    Button date;
    CheckBox ch;

    private int mYear, mMonth, mDay,mHour, mMinute;
    private int sety,setmt,setday,sethr,setmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        DialogDate obj= new DialogDate();

        RelativeLayout rr = (RelativeLayout) findViewById(R.id.rr3);

/*
        if(obj.getMedname().isEmpty())
        {
            rr.setVisibility(View.GONE);
        }
        else
        {
            rr.setVisibility(View.VISIBLE);
            med1.setText(obj.getMedname());
        }*/



        hairfall = (Button) findViewById(R.id.hairfall);
        hairfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Prescription.this,AddMed.class));
            }
        });

        date = (Button) findViewById(R.id.date);

        ch =(CheckBox) findViewById(R.id.chbox);
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked )
                {
                    date.setVisibility(View.GONE);

                }else{
                    date.setVisibility(View.VISIBLE);
                }
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(Prescription.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Display Selected date in textbox
                                String d = String.valueOf(dayOfMonth);
                                String m = String.valueOf(monthOfYear + 1);
                                String y = String.valueOf(year);
                                sety = year;
                                setmt = monthOfYear + 1;
                                setday = dayOfMonth;

                                StringBuilder da = new StringBuilder().append("Review Date :").append(d).append("-").append(m).append("-").append(y);
                               date.setText(da);

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
            }


        });


        submit = (Button) findViewById(R.id.next);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Prescription.this,ViewPrescription.class));
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });



    }
}
