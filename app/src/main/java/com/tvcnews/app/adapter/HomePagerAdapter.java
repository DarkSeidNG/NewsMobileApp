package com.tvcnews.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tvcnews.app.fragment.NewsFragment;
import com.tvcnews.app.fragment.StreamingFragment;
import com.tvcnews.app.fragment.SocialFragment;

/**
 * Created by iFwAxTel on 08/01/2017.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private static int PAGE_COUNT = 3;
    private static final String[] pageTitle = {"News","Streaming","Social"};

    /**
     * Instantiates a new Home pager adapter.
     *
     * @param fm the fm
     */
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NewsFragment.newInstance(1,"News");
            case 1:
                return StreamingFragment.newInstance(2,"Streaming");
            case 2:
                return SocialFragment.newInstance(3,"Add Department");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public  CharSequence getPageTitle(int position){
        return pageTitle[position];
    }
}