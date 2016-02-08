package com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.today.CaseView;

/**
 * Created by krishnathakur on 1/13/16.
 */
public class ConsultationHistory extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //Toast.makeText(getActivity(),"G"+position,Toast.LENGTH_SHORT).show();
            window.setStatusBarColor(getResources().getColor(R.color.Green700));


        }*/
        return inflater.inflate(R.layout.casepreview_patientdetail_frag, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());

        final ImageView rr = (ImageView) view.findViewById(R.id.imageView1);
        final ImageView rr2 = (ImageView) view.findViewById(R.id.imageView13);
        final ImageView icon = (ImageView) view.findViewById(R.id.imageView2);
        final ImageView icon2 = (ImageView) view.findViewById(R.id.imageView15);
        icon.setTag("up");
        icon2.setTag("up");

        final TextView et = (TextView) view.findViewById(R.id.etrr);
        final TextView et2 = (TextView) view.findViewById(R.id.etrr2);


        et.setVisibility(View.GONE);
        et2.setVisibility(View.GONE);

        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(icon.getTag().equals("up"))
                {
                    et.setVisibility(View.VISIBLE);
                    icon.setBackground(getResources().getDrawable(R.drawable.minus));
                    icon.setTag("down");
                }
                else
                {
                    et.setVisibility(View.GONE);
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
                    et2.setVisibility(View.VISIBLE);
                    icon2.setBackground(getResources().getDrawable(R.drawable.minus));
                    icon2.setTag("down");
                }
                else
                {
                    et2.setVisibility(View.GONE);
                    icon2.setBackground(getResources().getDrawable(R.drawable.plus));
                    icon2.setTag("up");
                }
            }
        });

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent myIntent = new Intent(getActivity(), CaseDetail.class);
                getActivity().startActivity(myIntent);*/
            }
        });
        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent myIntent = new Intent(getActivity(), CaseDetail.class);
                getActivity().startActivity(myIntent);*/
            }
        });
        /*TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));*/
    }
    public int getPotition()
    {
        return FragmentPagerItem.getPosition(getArguments());
    }
}
