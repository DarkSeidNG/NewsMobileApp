package com.ifwaxtel.newsapp.adapter;

import com.ifwaxtel.newsapp.fragment.NewsFragment;
import com.ifwaxtel.newsapp.fragment.SocialFragment;
import com.ifwaxtel.newsapp.fragment.StreamingFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by iFwAxTel on 08/01/2017.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private static int PAGE_COUNT = 3;
    private static final String[] pageTitle = {"News", "Streaming", "Social"};

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
        switch (position) {
            case 0:
                return NewsFragment.newInstance(1, "News");
            case 1:
                return StreamingFragment.newInstance(2, "Streaming");
            case 2:
                return SocialFragment.newInstance(3, "Add Department");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}