package com.tvcnews.app.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tvcnews.app.R;
import com.tvcnews.app.dialog.ContactUs;
import com.tvcnews.app.util.RateApp;

/**
 * The type Settings activity.
 */
public class SettingsActivity extends AppCompatActivity {
    /**
     * The Menu but.
     */
    ImageView menuBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_settings);

        setUpViews();

    }

    private void setUpViews(){
        menuBut = (ImageView) findViewById(R.id.home);

        menuBut.setOnClickListener(clickManager);
    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.home:
                    finish();
                    break;
            }
        }
    };

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
