package com.tvcnews.app.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tvcnews.app.R;
import com.tvcnews.app.adapter.NewsListAdapter;
import com.tvcnews.app.adapter.ScheduleListAdapter;
import com.tvcnews.app.dialog.ContactUs;
import com.tvcnews.app.model.NewsItemsObject;
import com.tvcnews.app.model.ScheduleObject;
import com.tvcnews.app.util.Divider;
import com.tvcnews.app.util.ItemClickSupport;
import com.tvcnews.app.util.RateApp;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    DrawerLayout drawer;
    LinearLayout leftDrawer;
    AppCompatSpinner sorterSpinner;
    ImageView menuBut;

    RecyclerView recList;
    ScheduleListAdapter adapter;
    ArrayList array = new ArrayList();

    RelativeLayout homeCont,scheduleCont,bookmarksCont,contactCont,tipsCont,rateCont;

    RelativeLayout statusBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_schedule);

        setUpViews();

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
            statusBar.setVisibility(View.VISIBLE);
        }

        populateContent();
        adapter = new ScheduleListAdapter(getApplicationContext(),array);
        recList.addItemDecoration(new Divider(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recList.setLayoutManager(llm);

        recList.setAdapter(adapter);

        ItemClickSupport.addTo(recList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

            }
        });
    }

    private void populateContent(){
        for (int i = 0; i<5; i++){
            ScheduleObject no = new ScheduleObject();
            array.add(no);
        }
    }

    private void setUpViews(){
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        sorterSpinner = (AppCompatSpinner)findViewById(R.id.sorterSpinner);
        leftDrawer = (LinearLayout) findViewById(R.id.left_drawer);
        menuBut = (ImageView) findViewById(R.id.home);
        statusBar = (RelativeLayout)findViewById(R.id.statusBar);

        recList = (RecyclerView)findViewById(R.id.recList);

        homeCont = (RelativeLayout) findViewById(R.id.homeCont);
        scheduleCont = (RelativeLayout) findViewById(R.id.scheduleCont);
        bookmarksCont = (RelativeLayout) findViewById(R.id.bookmarksCont);
        contactCont = (RelativeLayout) findViewById(R.id.contactCont);
        tipsCont = (RelativeLayout) findViewById(R.id.tipsCont);
        rateCont = (RelativeLayout) findViewById(R.id.rateCont);

        menuBut.setOnClickListener(clickManager);

        homeCont.setOnClickListener(drawerClickManager);
        scheduleCont.setOnClickListener(drawerClickManager);
        bookmarksCont.setOnClickListener(drawerClickManager);
        contactCont.setOnClickListener(drawerClickManager);
        tipsCont.setOnClickListener(drawerClickManager);
        rateCont.setOnClickListener(drawerClickManager);
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
                    Intent in = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(in);
                    break;
                case R.id.scheduleCont:
                    drawer.closeDrawer(GravityCompat.START);
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
                    RateApp rate = new RateApp(ScheduleActivity.this);
                    rate.rateApp();
                    break;
            }
        }
    };

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
        if(Build.VERSION.SDK_INT>=21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
