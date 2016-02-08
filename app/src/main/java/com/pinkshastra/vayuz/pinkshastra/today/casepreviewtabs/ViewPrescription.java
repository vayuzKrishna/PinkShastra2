package com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.pinkshastra.vayuz.pinkshastra.Confirmation;
import com.pinkshastra.vayuz.pinkshastra.R;

public class ViewPrescription extends AppCompatActivity {

    Toolbar toolbar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prescription);

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


        TextView txt = (TextView)findViewById(R.id.sample1).findViewById(R.id.title);
        TextView txt2 = (TextView)findViewById(R.id.sample2).findViewById(R.id.title);



        final ImageView rr = (ImageView) findViewById(R.id.imageView1);
        final ImageView rr2 = (ImageView) findViewById(R.id.imageView13);
        final ImageView icon = (ImageView) findViewById(R.id.imageView2);
        final ImageView icon2 = (ImageView) findViewById(R.id.imageView15);

        final RelativeLayout rr1 = (RelativeLayout) findViewById(R.id.rrmclick);
        final RelativeLayout rr3 = (RelativeLayout) findViewById(R.id.rrmed2);

        icon.setTag("up");
        icon2.setTag("up");




        rr1.setVisibility(View.GONE);
        rr3.setVisibility(View.GONE);

        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(icon.getTag().equals("up"))
                {
                    rr1.setVisibility(View.VISIBLE);
                    icon.setBackground(getResources().getDrawable(R.drawable.minus));
                    icon.setTag("down");
                }
                else
                {
                    rr1.setVisibility(View.GONE);
                    icon.setBackground(getResources().getDrawable(R.drawable.plus));
                    icon.setTag("up");
                }
            }
        });
        rr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(icon2.getTag().equals("up"))
                {
                    rr3.setVisibility(View.VISIBLE);
                    icon2.setBackground(getResources().getDrawable(R.drawable.minus));
                    icon2.setTag("down");
                }
                else
                {
                    rr3.setVisibility(View.GONE);
                    icon2.setBackground(getResources().getDrawable(R.drawable.plus));
                    icon2.setTag("up");
                }
            }
        });




        txt.setText("Solution : ");
        txt2.setText("Remarks : ");
        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.sample1)
                .findViewById(R.id.expand_text_view);
        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv2 = (ExpandableTextView) findViewById(R.id.sample2)
                .findViewById(R.id.expand_text_view);

        expTv1.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                Toast.makeText(getApplicationContext(), isExpanded ? "Expanded" : "Collapsed", Toast.LENGTH_SHORT).show();
            }
        });

// IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(getString(R.string.dummy_text1));
        expTv2.setText(getString(R.string.dummy_text1));


        button=(Button) findViewById(R.id.casei);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPrescription.this,Confirmation.class));
            }
        });
    }
}
