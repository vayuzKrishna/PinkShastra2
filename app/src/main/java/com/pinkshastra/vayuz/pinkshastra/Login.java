package com.pinkshastra.vayuz.pinkshastra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.pinkshastra.vayuz.pinkshastra.discovery.AppPreferences;

public class Login extends ActionBarActivity {

    Button login;
    Button button;
    AppPreferences _appPrefs;
    //FileHandle fhand;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* a =(ImageButton) findViewById(R.id.a);
        b =(ImageButton) findViewById(R.id.b);
        c =(ImageButton) findViewById(R.id.c);*/


        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _appPrefs.saveSmsBody("true");
                Intent intent = new Intent(Login.this,Nav.class);
                startActivity(intent);

            }
        });

        _appPrefs = new AppPreferences(getApplicationContext());
    }
    public void onClick(View v) {
    }

}
