package com.pinkshastra.vayuz.pinkshastra;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Digvijay on 21-07-2015.
 */
public class NavFrag extends Fragment {

    private ActionBarDrawerToggle mdrawerToggle;
    public static final String PREF_FILE_NAME="testpref";
    private DrawerLayout mdrawer_layout;
    private View containerView;
    public NavFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.nav_header_nav, container, false);
    }


    public void setup(int fragmentid, DrawerLayout drawerLayout, final android.support.v7.widget.Toolbar toolbar) {
        mdrawer_layout = drawerLayout;
        //  mdrawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawerLayout.findViewById(R.id.fragment_nav));

        containerView =getActivity().findViewById(fragmentid) ;
        mdrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                getActivity().invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }

            /*@Override
           /* public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6)
                {
                toolbar.setAlpha(1-slideOffset);
                }
            }*/
        };

        mdrawer_layout.setDrawerListener(mdrawerToggle);
        mdrawer_layout.post(new Runnable() {

            @Override
            public void run() {
                mdrawerToggle.syncState();
            }
        });
    }



}
