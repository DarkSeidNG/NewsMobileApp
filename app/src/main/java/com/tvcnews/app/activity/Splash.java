package com.tvcnews.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.tvcnews.app.R;


/**
 * The type Splash.
 */
public class Splash extends AppCompatActivity {

    /**
     * The .
     */
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable()
        {
            public void run() {
                i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
