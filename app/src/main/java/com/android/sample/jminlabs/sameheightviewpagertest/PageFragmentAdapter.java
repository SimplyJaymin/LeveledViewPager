package com.android.sample.jminlabs.sameheightviewpagertest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jayminraval on 2017-05-08.
 */
public class PageFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public PageFragmentAdapter(FragmentManager fragmentManager, @NonNull List<Fragment> fragments) {
        super(fragmentManager);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
