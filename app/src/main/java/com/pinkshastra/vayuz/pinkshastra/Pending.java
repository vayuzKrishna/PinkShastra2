package com.pinkshastra.vayuz.pinkshastra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;
import com.pinkshastra.vayuz.pinkshastra.pending.Expired;

/**
 * Created by krishnathakur on 1/9/16.
 */
public class Pending extends Fragment {

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag= inflater.inflate(R.layout.frag_pending, container, false);
// Create the adapter that will return a fragment for each of the three

        return frag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        // primary sections of the activity.
        mViewPager = (ViewPager) view.findViewById(R.id.conpen);

        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.pt);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        //for (int titleResId : demo.tabs()) {
        pages.add(FragmentPagerItem.of("Pending", Pendin.class));
        pages.add(FragmentPagerItem.of("Expired", Expired.class));
        // }

        FragmentStatePagerItemAdapter adapter = new FragmentStatePagerItemAdapter(
                getActivity().getSupportFragmentManager(), pages);

        mViewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(mViewPager);
        /*TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));*/
    }
    public int getPotition()
    {
        return FragmentPagerItem.getPosition(getArguments());
    }
}
