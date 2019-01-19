package com.tvcnews.app.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tvcnews.app.R;
import com.tvcnews.app.adapter.HomePagerAdapter;
import com.tvcnews.app.dialog.ContactUs;
import com.tvcnews.app.util.ChangeTint;
import com.tvcnews.app.util.RateApp;
import com.tvcnews.app.widget.boommenu.BoomMenuButton;
import com.tvcnews.app.widget.boommenu.Types.BoomType;
import com.tvcnews.app.widget.boommenu.Types.ButtonType;
import com.tvcnews.app.widget.boommenu.Types.PlaceType;
import com.tvcnews.app.widget.boommenu.Util;

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
    private BoomMenuButton boomMenuButton;
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
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
            RelativeLayout statusBar = (RelativeLayout)findViewById(R.id.statusBar);
            statusBar.setVisibility(View.VISIBLE);
        }

        setUpViews();

        adapter = new HomePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageChange);

        tabLayout.setupWithViewPager(viewPager);
        setUpTabIcons();

        boomMenuButton = (BoomMenuButton)findViewById(R.id.boom);

        homeIcon.setImageDrawable(new ChangeTint(getApplicationContext()).tintedIcon(R.drawable.ic_home));


    }

    /**
     * Get status bar height int.
     *
     * @return the int
     */
    public int getStatusBarHeight(){
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId>0){
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setUpViews(){
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        menuBut = (ImageView) findViewById(R.id.home);
        sorterSpinner = (AppCompatSpinner)findViewById(R.id.sorterSpinner);
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

    private void setUpTabIcons(){

        tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.colorPrimaryDark));

    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.home:
                    drawer.openDrawer(GravityCompat.START);
                    break;
            }
        }
    };

    private View.OnClickListener drawerClickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.homeCont:
                    drawer.closeDrawer(GravityCompat.START);
                    break;
                case R.id.scheduleCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent in = new Intent(getApplicationContext(),ScheduleActivity.class);
                    startActivity(in);
                    break;
                case R.id.bookmarksCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent inten = new Intent(getApplicationContext(),BookmarksActivity.class);
                    startActivity(inten);
                    break;
                case R.id.contactCont:
                    drawer.closeDrawer(GravityCompat.START);
                    ContactUs contactUs = new ContactUs();
                    contactUs.show(getSupportFragmentManager(),"");
                    break;
                case R.id.tipsCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent intena = new Intent(getApplicationContext(),SettingsActivity.class);
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

            switch(position){
                case 0:
                    boomMenuButton.setVisibility(View.VISIBLE);
                    sorterSpinner.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    boomMenuButton.setVisibility(View.VISIBLE);
                    sorterSpinner.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    boomMenuButton.setVisibility(View.GONE);
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

        initBoom();
    }

    private void initBoom() {

        // Now with Builder, you can init BMB more convenient
        new BoomMenuButton.Builder()
                .addSubButton(getApplicationContext(),R.drawable.ic_news,getButtonColor("#FFD1AE17"),"IReporter \n....")
                .addSubButton(getApplicationContext(),R.drawable.ic_camera,getButtonColor("#000000"),"Upload Images")
                .addSubButton(getApplicationContext(),R.drawable.ic_videocam,getButtonColor("#000000"),"Upload Videos")
                .button(ButtonType.CIRCLE)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.CIRCLE_3_3)
                .subButtonTextColor(ContextCompat.getColor(this, R.color.white))
                .subButtonsShadow(Util.getInstance().dp2px(1), Util.getInstance().dp2px(1))
                .onSubButtonClick(boomListener)
                .init(boomMenuButton);
    }

    private BoomMenuButton.OnSubButtonClickListener boomListener = new BoomMenuButton.OnSubButtonClickListener() {
        @Override
        public void onClick(int buttonIndex) {
            switch(buttonIndex){
                case 0:
                    break;
                case 1:
                    Intent intent = new Intent(getApplicationContext(),UploadPicActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    Intent inten = new Intent(getApplicationContext(),UploadVidActivity.class);
                    startActivity(inten);
                    break;
            }
        }
    };

    private int[] getButtonColor(String color){
        int[] colors = new int[2];
        colors[1] = Color.parseColor(color);
        colors[0] = Util.getInstance().getPressedColor(colors[1]);
        return colors;
    }

    @Override
    public void onBackPressed() {
        if (boomMenuButton.isClosed()){
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        } else {
            boomMenuButton.dismiss();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(Build.VERSION.SDK_INT>=21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
