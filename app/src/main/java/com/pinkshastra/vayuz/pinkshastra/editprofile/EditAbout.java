package com.pinkshastra.vayuz.pinkshastra.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.profile.Profile;

/**
 * Created by krishnathakur on 1/14/16.
 */
public class EditAbout extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //Toast.makeText(getActivity(),"G"+position,Toast.LENGTH_SHORT).show();
            window.setStatusBarColor(getResources().getColor(R.color.Green700));


        }*/
        return inflater.inflate(R.layout.edit_about_frag, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        Button update = (Button) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Profile.class));
            }
        });

        /*TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));*/
    }

    public int getPotition() {
        return FragmentPagerItem.getPosition(getArguments());
    }
}