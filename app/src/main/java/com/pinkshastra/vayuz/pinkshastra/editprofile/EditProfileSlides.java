package com.pinkshastra.vayuz.pinkshastra.editprofile;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.discovery.PageFragment;
import com.pinkshastra.vayuz.pinkshastra.discovery.PageFragment2;
import com.pinkshastra.vayuz.pinkshastra.discovery.PageFragment3;
import com.pinkshastra.vayuz.pinkshastra.discovery.PageFragment4;
import com.pinkshastra.vayuz.pinkshastra.discovery.PageFragment5;

public class EditProfileSlides extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_slides);

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

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        //for (int titleResId : demo.tabs()) {
        pages.add(FragmentPagerItem.of("A", EditAbout.class));
        pages.add(FragmentPagerItem.of("B", EditContact.class));
        pages.add(FragmentPagerItem.of("C", EditEducation.class));
        pages.add(FragmentPagerItem.of("D", EditExperience.class));
        // }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);


    }
}
