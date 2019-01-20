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

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.adapter.NewsListAdapter;
import com.ifwaxtel.newsapp.dialog.ContactUs;
import com.ifwaxtel.newsapp.model.NewsItemsObject;
import com.ifwaxtel.newsapp.util.Divider;
import com.ifwaxtel.newsapp.util.ItemClickSupport;
import com.ifwaxtel.newsapp.util.RateApp;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The type Bookmarks activity.
 */
public class BookmarksActivity extends AppCompatActivity {

    /**
     * The Drawer.
     */
    DrawerLayout drawer;
    /**
     * The Left drawer.
     */
    LinearLayout leftDrawer;
    /**
     * The Sorter spinner.
     */
    AppCompatSpinner sorterSpinner;
    /**
     * The Menu but.
     */
    ImageView menuBut;

    /**
     * The Rec list.
     */
    RecyclerView recList;
    /**
     * The Adapter.
     */
    NewsListAdapter adapter;
    /**
     * The Array.
     */
    ArrayList array = new ArrayList();

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
     * The Status bar.
     */
    RelativeLayout statusBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_bookmarks);

        setUpViews();

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            statusBar.setVisibility(View.VISIBLE);
        }
        populateContent();
        adapter = new NewsListAdapter(getApplicationContext(), array);
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

    private void setUpViews() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        sorterSpinner = (AppCompatSpinner) findViewById(R.id.sorterSpinner);
        leftDrawer = (LinearLayout) findViewById(R.id.left_drawer);
        menuBut = (ImageView) findViewById(R.id.home);

        recList = (RecyclerView) findViewById(R.id.recList);

        homeCont = (RelativeLayout) findViewById(R.id.homeCont);
        scheduleCont = (RelativeLayout) findViewById(R.id.scheduleCont);
        bookmarksCont = (RelativeLayout) findViewById(R.id.bookmarksCont);
        contactCont = (RelativeLayout) findViewById(R.id.contactCont);
        tipsCont = (RelativeLayout) findViewById(R.id.tipsCont);
        rateCont = (RelativeLayout) findViewById(R.id.rateCont);
        statusBar = (RelativeLayout) findViewById(R.id.statusBar);

        menuBut.setOnClickListener(clickManager);

        homeCont.setOnClickListener(drawerClickManager);
        scheduleCont.setOnClickListener(drawerClickManager);
        bookmarksCont.setOnClickListener(drawerClickManager);
        contactCont.setOnClickListener(drawerClickManager);
        tipsCont.setOnClickListener(drawerClickManager);
        rateCont.setOnClickListener(drawerClickManager);
    }

    private void populateContent() {
        String[] titles = getResources().getStringArray(R.array.news_title);
        String[] body = getResources().getStringArray(R.array.news_body);

        for (int i = 0; i < titles.length; i++) {
            NewsItemsObject no = new NewsItemsObject();
            no.setTitle(titles[i]);
            no.setBody(body[i]);
            no.setChecked(true);
            if (i == 0) {
                no.setImage(getResources().getDrawable(R.drawable.article_6));
            }
            if (i == 1) {
                no.setImage(getResources().getDrawable(R.drawable.article_1));
            }
            if (i == 2) {
                no.setImage(getResources().getDrawable(R.drawable.article_2));
            }
            if (i == 3) {
                no.setImage(getResources().getDrawable(R.drawable.article_3));
            }
            if (i == 4) {
                no.setImage(getResources().getDrawable(R.drawable.article_4));
            }
            if (i == 5) {
                no.setImage(getResources().getDrawable(R.drawable.article_5));
            }
            //no.setImage(getResources().getDrawable(Integer.parseInt(img[i])));
            array.add(no);
        }
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
                    Intent in = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(in);
                    break;
                case R.id.scheduleCont:
                    drawer.closeDrawer(GravityCompat.START);
                    Intent inten = new Intent(getApplicationContext(), ScheduleActivity.class);
                    startActivity(inten);
                    break;
                case R.id.bookmarksCont:
                    drawer.closeDrawer(GravityCompat.START);
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
                    RateApp rate = new RateApp(BookmarksActivity.this);
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
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
