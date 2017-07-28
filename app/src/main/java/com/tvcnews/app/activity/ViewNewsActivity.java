package com.tvcnews.app.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tvcnews.app.R;

public class ViewNewsActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fab;
    AppBarLayout appBarLayout;
    ImageView back, save, imageView4, award_1,award_2;
    TextView title,newsBody;
    int id;

    RelativeLayout statusBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_view_news);

        Intent intent = getIntent();
        id = intent.getIntExtra("position",0);

        appBarLayout = (AppBarLayout)findViewById(R.id.app_bar);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        back = (ImageView)findViewById(R.id.back);
        save = (ImageView)findViewById(R.id.save);
        award_1 = (ImageView)findViewById(R.id.award_1);
        award_2 = (ImageView)findViewById(R.id.award_2);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        title = (TextView)findViewById(R.id.title);
        newsBody = (TextView)findViewById(R.id.newsBody);
        statusBar = (RelativeLayout)findViewById(R.id.statusBar);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);

        appBarLayout.addOnOffsetChangedListener(this);
        back.setOnClickListener(clickManager);
        save.setOnClickListener(clickManager);
        fab.setOnClickListener(clickManager);

        title.setText(getResources().getStringArray(R.array.news_title)[id]);
        newsBody.setText(getResources().getStringArray(R.array.news_body)[id]);
        if (id==0){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_6));
                award_1.setVisibility(View.VISIBLE);
                award_2.setVisibility(View.VISIBLE);
        }
        if (id==1){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_1));
        }
        if (id==2){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_2));
        }
        if (id==3){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_3));
        }
        if (id==4){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_4));
        }
        if (id==5){
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.article_5));
        }

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
            statusBar.setVisibility(View.VISIBLE);
        }

    }


    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.back:
                    finish();
                    break;
                case R.id.save:
                    Toast.makeText(getApplicationContext(), "Save Clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.fab:
                    Toast.makeText(getApplicationContext(), "Save Clicked", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (Math.abs(verticalOffset)==appBarLayout.getTotalScrollRange()){
            //closed
            save.setVisibility(View.VISIBLE);
        }
        else if (Math.abs(verticalOffset)<appBarLayout.getTotalScrollRange()){
            //closed
            save.setVisibility(View.GONE);
        }
        else if (verticalOffset == 0){
            //open
            save.setVisibility(View.GONE);
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
