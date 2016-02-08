package com.pinkshastra.vayuz.pinkshastra.today;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.pinkshastra.vayuz.pinkshastra.R;

/**
 * Created by krishnathakur on 1/9/16.
 */
public class TDone extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag= inflater.inflate(R.layout.tdd, container, false);

        return frag;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        RelativeLayout rr = (RelativeLayout) view.findViewById(R.id.rrdone);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","Done");
                startActivity(intent);
            }
        });

        RelativeLayout rr1 = (RelativeLayout) view.findViewById(R.id.rrdone1);
        rr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","Done");
                startActivity(intent);
            }
        });

        RelativeLayout rr2 = (RelativeLayout) view.findViewById(R.id.rrdone2);
        rr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","Done");
                startActivity(intent);
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
