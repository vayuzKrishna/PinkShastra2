package com.pinkshastra.vayuz.pinkshastra;

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
import com.pinkshastra.vayuz.pinkshastra.today.CasePreview;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.Prescription;

/**
 * Created by krishnathakur on 1/9/16.
 */
public class Pendin extends Fragment{

    @Override
    public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag= inflater.inflate(R.layout.pen_pen_frag, container, false);


        RelativeLayout obj = (RelativeLayout) frag.findViewById(R.id.pen);
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","pending");
                startActivity(intent);
            }
        });
        RelativeLayout obj1 = (RelativeLayout) frag.findViewById(R.id.pen1);
        obj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","pending");
                startActivity(intent);
            }
        });
        RelativeLayout obj2 = (RelativeLayout) frag.findViewById(R.id.pen2);
        obj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CasePreview.class);
                intent.putExtra("Tag","pending");
                startActivity(intent);
            }
        });

        return frag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());

        /*TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));*/
    }
    public int getPotition()
    {
        return FragmentPagerItem.getPosition(getArguments());
    }
}
