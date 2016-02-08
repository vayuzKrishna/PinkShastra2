package com.pinkshastra.vayuz.pinkshastra.editprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pinkshastra.vayuz.pinkshastra.R;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{


    Toolbar toolbar;
    ImageView ab,co,ed,ex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

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

        ab = (ImageView) findViewById(R.id.ab);
        co = (ImageView) findViewById(R.id.co);
        ed = (ImageView) findViewById(R.id.ed);
        ex = (ImageView) findViewById(R.id.ex);

        ab.setOnClickListener(this);
        co.setOnClickListener(this);
        ed.setOnClickListener(this);
        ex.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ab:
                startActivity(new Intent(EditProfile.this,EditProfileSlides.class));
                break;
            case R.id.co:
                startActivity(new Intent(EditProfile.this,EditProfileSlides.class));
                break;
            case R.id.ed:
                startActivity(new Intent(EditProfile.this,EditProfileSlides.class));
                break;
            case R.id.ex:
                startActivity(new Intent(EditProfile.this,EditProfileSlides.class));
                break;
        }
    }
}
