package com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.pinkshastra.vayuz.pinkshastra.R;

/**
 * Created by krishnathakur on 1/13/16.
 */
public class CaseDetail extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //Toast.makeText(getActivity(),"G"+position,Toast.LENGTH_SHORT).show();
            window.setStatusBarColor(getResources().getColor(R.color.Green700));


        }*/
        View frag= inflater.inflate(R.layout.casepreview_casedetail_frag, container, false);

        return frag;

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        ImageView rr = (ImageView) view.findViewById(R.id.imageView13);
        ImageView rr2 = (ImageView) view.findViewById(R.id.imageView14);

        final ImageView icon = (ImageView) view.findViewById(R.id.imageView19);
        icon.setTag("up");
        final ImageView icon2 = (ImageView) view.findViewById(R.id.imageView20);
        icon2.setTag("up");

        final RelativeLayout et = (RelativeLayout) view.findViewById(R.id.hairlayout);
        final RelativeLayout et2 = (RelativeLayout) view.findViewById(R.id.bonlayout);

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
        /*TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));*/
    }
    public int getPotition()
    {
        return FragmentPagerItem.getPosition(getArguments());
    }
}
