package com.pinkshastra.vayuz.pinkshastra.today;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.profile.About;
import com.pinkshastra.vayuz.pinkshastra.profile.Contact;
import com.pinkshastra.vayuz.pinkshastra.profile.Education;
import com.pinkshastra.vayuz.pinkshastra.profile.Experience;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.CaseDetail;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.ConsultationHistory;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.PatientDeatail;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.Prescription;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.ViewPrescription;

public class CasePreview extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    String Tag;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_preview);

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
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Tag = extras.getString("Tag");
        }
        if(Tag.equals("Done"))
        {
            next.setText("View Prescription");
            next.setClickable(true);
            next.setEnabled(true);
        }
        else if(Tag.equals("pending"))
        {
            next.setClickable(true);
            next.setEnabled(true);
            next.setText("Prescribe");
        }
        else
        {
            next.setText("Prescribe");
            next.setBackgroundColor(getResources().getColor(R.color.Grey));
            next.setClickable(false);
            next.setFocusable(false);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        //for (int titleResId : demo.tabs()) {
        pages.add(FragmentPagerItem.of("Case Detail", CaseDetail.class));
        pages.add(FragmentPagerItem.of("Patient Details", PatientDeatail.class));
        pages.add(FragmentPagerItem.of("Consultation History", ConsultationHistory.class));
        // }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);
    }

    public void init()
    {
        next = (Button) findViewById(R.id.prescribe);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.prescribe:
                    if(Tag.equals("Prescribe"))
                    {
                        startActivity(new Intent(CasePreview.this, Prescription.class));
                    }
                else if(Tag.equals("Done"))
                    {
                        startActivity(new Intent(CasePreview.this, ViewPrescription.class));
                    }
                else if(Tag.equals("pending"))
                    {
                        startActivity(new Intent(CasePreview.this, Prescription.class));
                    }
                break;
        }
    }
}
