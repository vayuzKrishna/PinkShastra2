package com.pinkshastra.vayuz.pinkshastra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;
import com.pinkshastra.vayuz.pinkshastra.today.Cancelled;
import com.pinkshastra.vayuz.pinkshastra.today.Rescheduled;
import com.pinkshastra.vayuz.pinkshastra.today.TDone;
import com.pinkshastra.vayuz.pinkshastra.today.Upcommings;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.CaseDetail;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.ConsultationHistory;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.PatientDeatail;

/**
 * Created by krishnathakur on 1/9/16.
 */
public class Today extends Fragment  {

    private ViewPager mViewPager;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag= inflater.inflate(R.layout.frag_todays, container, false);
// Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.

        return frag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        mViewPager = (ViewPager) view.findViewById(R.id.cont);

        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.ttt);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        //for (int titleResId : demo.tabs()) {
        pages.add(FragmentPagerItem.of("Upcoming", Upcommings.class));
        pages.add(FragmentPagerItem.of("Done", TDone.class));
        pages.add(FragmentPagerItem.of("Cancelled", Cancelled.class));
        pages.add(FragmentPagerItem.of("Rescheduled", Rescheduled.class));
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
