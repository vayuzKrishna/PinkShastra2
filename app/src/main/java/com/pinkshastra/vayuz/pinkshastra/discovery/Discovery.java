package com.pinkshastra.vayuz.pinkshastra.discovery;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.pinkshastra.vayuz.pinkshastra.Login;
import com.pinkshastra.vayuz.pinkshastra.Nav;
import com.pinkshastra.vayuz.pinkshastra.R;

public class Discovery extends AppCompatActivity {

    TextView sk;
    ImageView imnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        sk = (TextView) findViewById(R.id.skip);
        imnext = (ImageView) findViewById(R.id.view);

        imnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Discovery.this,Login.class));
            }
        });
        sk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Discovery.this,Login.class));
            }
        });
        /*ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(demo.layoutResId, tab, false));*/

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        //for (int titleResId : demo.tabs()) {
            pages.add(FragmentPagerItem.of("A", PageFragment.class));
            pages.add(FragmentPagerItem.of("B", PageFragment2.class));
            pages.add(FragmentPagerItem.of("C", PageFragment3.class));
            pages.add(FragmentPagerItem.of("D", PageFragment4.class));
            pages.add(FragmentPagerItem.of("E", PageFragment5.class));
       // }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);
    }


}
