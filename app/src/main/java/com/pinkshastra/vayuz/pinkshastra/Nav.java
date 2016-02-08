package com.pinkshastra.vayuz.pinkshastra;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.actionitembadge.library.ActionItemBadgeAdder;
import com.mikepenz.actionitembadge.library.utils.BadgeStyle;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;
import com.pinkshastra.vayuz.pinkshastra.profile.About;
import com.pinkshastra.vayuz.pinkshastra.profile.Contact;
import com.pinkshastra.vayuz.pinkshastra.profile.Education;
import com.pinkshastra.vayuz.pinkshastra.profile.Experience;
import com.pinkshastra.vayuz.pinkshastra.profile.Profile;


public class Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    Toolbar toolbar;
    private int badgeCount = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.logoapp, null));
        else
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
   */     getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        initFrags();
        init();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void init()
    {
        LinearLayout ll = (LinearLayout) findViewById(R.id.profilell);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nav.this,Profile.class);
                startActivityForResult(intent, 0);
                overridePendingTransition(R.anim.slide_out, R.anim.slide_in);

            }
        });
    }
    public void initFrags()
    {

        ViewPager viewPager = (ViewPager) findViewById(R.id.maincontainor);
       final SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.maintabs);
        //demo.setup(viewPagerTab);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        //for (int titleResId : demo.tabs()) {
        pages.add(FragmentPagerItem.of("Consultation", Today.class));
        pages.add(FragmentPagerItem.of("Prescription", Pending.class));
        pages.add(FragmentPagerItem.of("Missed Cases", MissedCases.class));
        // }

        FragmentStatePagerItemAdapter adapter = new FragmentStatePagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);

        viewPagerTab.setViewPager(viewPager);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int menuToUse = R.menu.my_righthandmenu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(menuToUse, menu);

        if (badgeCount > 0) {
            Drawable myIcon = getResources().getDrawable( R.drawable.noticopy );
            ActionItemBadge.update(this,menu.findItem(R.id.noti),myIcon,ActionItemBadge.BadgeStyles.RED,badgeCount);
        } else {
            //ActionItemBadge.hide(menu.findItem(R.id.noti));
        }

       // new ActionItemBadgeAdder().act(this).menu(menu).title("2").itemDetails(0, 342, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).add(ActionItemBadge.BadgeStyles.GREY_LARGE, 1);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

         if(item.getItemId() == R.id.btnMyMenu)
        {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT);
            } else {
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
        }
        else if(item.getItemId() == R.id.cal)
         {
             startActivity(new Intent(Nav.this,CalanderView.class));
             return true;
         }
        else if(item.getItemId() == R.id.noti)
         {
             badgeCount--;
             //invalidateOptionsMenu();
             startActivity(new Intent(Nav.this,Notification.class));
             return true;
         }
        return false;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(Nav.this, Profile.class));

        }  else if (id == R.id.mypreshistory) {
            startActivity(new Intent(Nav.this, PrescriptionHistory.class));
        }
        else if(id == R.id.stats)
        {
            startActivity(new Intent(Nav.this, Statistics.class));
        }
        else if(id == R.id.Referadoctor)
        {
            startActivity(new Intent(Nav.this, Statistics.class));
        }
        else if(id == R.id.nav_send)
        {
            startActivity(new Intent(Nav.this, Statistics.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }


}
