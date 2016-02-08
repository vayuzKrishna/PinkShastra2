package com.pinkshastra.vayuz.pinkshastra.today;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pinkshastra.vayuz.pinkshastra.Nav;
import com.pinkshastra.vayuz.pinkshastra.R;

public class CaseViewCancle extends AppCompatActivity {

    Toolbar toolbar;
    Button submit;
    EditText other;

    private RadioGroup rg;
    private RadioButton radioSexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_view_cancle);

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



        other =(EditText) findViewById(R.id.other);


         rg = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = rg.getCheckedRadioButtonId();

        // find the radiobutton by returned id
         radioSexButton = (RadioButton) findViewById(selectedId);


        if(radioSexButton.getText().equals("Others"))
        {
            other.setVisibility(View.VISIBLE);
        }
        else if(radioSexButton.getText().equals("Professional"))
        {
            other.setVisibility(View.GONE);

        }


        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your appointment has been cancelled",Toast.LENGTH_LONG).show();
              startActivity(new Intent(CaseViewCancle.this, Nav.class));
            }
        });

    }
}
