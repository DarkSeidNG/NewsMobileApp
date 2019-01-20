package com.ifwaxtel.newsapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;
import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.adapter.HomePagerAdapter;
import com.ifwaxtel.newsapp.dialog.ContactUs;
import com.ifwaxtel.newsapp.util.ChangeTint;
import com.ifwaxtel.newsapp.util.RateApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * The type Home activity.
 */
public class HomeActivity extends AppCompatActivity {

    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Adapter.
     */
    FragmentPagerAdapter adapter;
    private boolean init = false;
    /**
     * The Sorter spinner.
     */
    AppCompatSpinner sorterSpinner;

    /**
     * The Drawer.
     */
    DrawerLayout drawer;
    /**
     * The Left drawer.
     */
    LinearLayout leftDrawer;
    /**
     * The Menu but.
     */
    ImageView menuBut;
    /**
     * The Tab layout.
     */
    TabLayout tabLayout;

    /**
     * The Home cont.
     */
    RelativeLayout homeCont, /**
     * The Schedule cont.
     */
    scheduleCont, /**
     * The Bookmarks cont.
     */
    bookmarksCont, /**
     * The Contact cont.
     */
    contactCont, /**
     * The Tips cont.
     */
    tipsCont, /**
     * The Rate cont.
     */
    rateCont;
    /**
     * The Home icon.
     */
    ImageView homeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_home);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            RelativeLayout statusBar = (RelativeLayout) findViewById(R.id.statusBar);
            statusBar.setVisibility(View.VISIBLE);
        }

        setUpViews();

        adapter = new HomePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageChange);

        tabLayout.setupWithViewPager(viewPager);
        setUpTabIcons();

        homeIcon.setImageDrawable(new ChangeTint(getApplicationContext()).tintedIcon(R.drawable.ic_home));


    }

    /**
     * Get status bar height int.
     *
     * @return the int
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setUpViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuBut = (ImageView) findViewById(R.id.home);
        sorterSpinner = (AppCompatSpinner) findViewById(R.id.sorterSpinner);
        leftDrawer = (LinearLayout) findViewById(R.id.left_drawer);


        homeCont = (RelativeLayout) findViewById(R.id.homeCont);
        scheduleCont = (RelativeLayout) findViewById(R.id.scheduleCont);
        bookmarksCont = (RelativeLayout) findViewById(R.id.bookmarksCont);
        contactCont = (RelativeLayout) findViewById(R.id.contactCont);
        tipsCont = (RelativeLayout) findViewById(R.id.tipsCont);
        rateCont = (RelativeLayout) findViewById(R.id.rateCont);
        homeIcon = (ImageView) findViewById(R.id.homeIcon);

        menuBut.setOnClickListener(clickManager);

        homeCont.setOnClickListener(drawerClickManager);
        scheduleCont.setOnClickListener(drawerClickManager);
        bookmarksCont.setOnClickListener(drawerClickManager);
        contactCont.setOnClickListener(drawerClickManager);
        tipsCont.setOnClickListener(drawerClickManager);
        rateCont.setOnClickListener(drawerClickManager);

    }

    private void setUpTabIcons() {

        tabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.colorPrimaryDark));

    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.home:
                    drawer.openDrawer(GravityCompat.START);
                    break;
            }
        }
    };

    private View.OnClickListener drawerClickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.homeCont:
                    drawer.closeDrawer(GravityCompat.START);
                    break;
                case R.id.scheduleCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent in = new Intent(getApplicationContext(), ScheduleActivity.class);
                    startActivity(in);
                    break;
                case R.id.bookmarksCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent inten = new Intent(getApplicationContext(), BookmarksActivity.class);
                    startActivity(inten);
                    break;
                case R.id.contactCont:
                    drawer.closeDrawer(GravityCompat.START);
                    ContactUs contactUs = new ContactUs();
                    contactUs.show(getSupportFragmentManager(), "");
                    break;
                case R.id.tipsCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent intena = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intena);
                    break;
                case R.id.rateCont:
                    drawer.closeDrawer(GravityCompat.START);
                    RateApp rate = new RateApp(HomeActivity.this);
                    rate.rateApp();
                    break;
            }
        }
    };


    private ViewPager.OnPageChangeListener pageChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            switch (position) {
                case 0:
                    sorterSpinner.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    sorterSpinner.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    sorterSpinner.setVisibility(View.GONE);

                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // Use a param to record whether the boom button has been initialized
        // Because we don't need to init it again when onResume()
        if (init) return;
        init = true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
