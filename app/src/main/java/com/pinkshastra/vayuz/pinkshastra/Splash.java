package com.pinkshastra.vayuz.pinkshastra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.pinkshastra.vayuz.pinkshastra.discovery.AppPreferences;
import com.pinkshastra.vayuz.pinkshastra.discovery.Discovery;

public class Splash extends ActionBarActivity {

    SharedPreferences settings;
    boolean firstRun;
    AppPreferences _appPrefs;
    //logoutpref _logprefs;
    //FileHandle fhand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       /* animation area*/

        final ImageView im = (ImageView) findViewById(R.id.imglogo);
        final TextView tx = (TextView)findViewById(R.id.textView20);


        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .playOn(findViewById(R.id.imglogo));




        settings=getSharedPreferences("prefs", 0);
        firstRun=settings.getBoolean("firstRun", false);

        _appPrefs = new AppPreferences(getApplicationContext());

        //_logprefs = new logoutpref(getApplicationContext());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startPercentMockThread();
            }
        }, 3000);




    }


    private void startPercentMockThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1800);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if(firstRun==false)//if running for first time
                    {
                        SharedPreferences.Editor editor=settings.edit();
                        editor.putBoolean("firstRun",true);
                        editor.commit();
                        Intent i=new Intent(Splash.this,Discovery.class);//Activity to be     launched For the First time
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        String s=_appPrefs.getSmsBody();
                        //String s2=fhand.readFileInternalStorage("f4", getApplicationContext());
                        if(s.equals("true"))/*s2.equals("false")*/
                        {
                            Intent a=new Intent(Splash.this,Nav.class);//Default Activity
                            startActivity(a);
                            finish();
                        }
                        else{

                            Intent b=new Intent(Splash.this,Login.class);//Default Activity
                            startActivity(b);
                            finish();
                        }
                    }
                }
            }
        };
        new Thread(runnable).start();
    }
}
