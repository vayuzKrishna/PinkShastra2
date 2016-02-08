package com.pinkshastra.vayuz.pinkshastra.pending;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pinkshastra.vayuz.pinkshastra.R;

/**
 * Created by krishnathakur on 1/9/16.
 */
public class Expired extends Fragment {


    @Override
    public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag= inflater.inflate(R.layout.pen_expired_frag, container, false);
        RelativeLayout pen = (RelativeLayout) frag.findViewById(R.id.pen);
        RelativeLayout pen1 = (RelativeLayout) frag.findViewById(R.id.pen1);
        RelativeLayout pen2 = (RelativeLayout) frag.findViewById(R.id.pen2);

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ExpiredView.class));
            }
        });
        pen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ExpiredView.class));
            }
        });
        pen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ExpiredView.class));
            }
        });

        return frag;
    }
}
