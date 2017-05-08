package com.android.sample.jminlabs.sameheightviewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.android.jminlabs.leveledviewpager.LeveledViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    LeveledViewPager mLeveledViewPager;

    @BindString(R.string.randomText_long_1)
    String mRandomTextLong1;

    @BindString(R.string.randomText_long_2)
    String mRandomTextLong2;

    @BindString(R.string.randomText_long_3)
    String mRandomTextLong3;

    @BindColor(android.R.color.darker_gray)
    int mDarkGray;

    @BindColor(android.R.color.holo_purple)
    int mHoloPurple;

    @BindColor(android.R.color.holo_orange_dark)
    int mHoloOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUi();
    }

    private void setupUi() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(PageFragment.newInstance(mDarkGray, mRandomTextLong1));
        fragments.add(PageFragment.newInstance(mHoloPurple, mRandomTextLong2));
        fragments.add(PageFragment.newInstance(mHoloOrange, mRandomTextLong3));
        PageFragmentAdapter adapter = new PageFragmentAdapter(getSupportFragmentManager(), fragments);
        mLeveledViewPager.setAdapter(adapter);
        mLeveledViewPager.setViewIdToLevel(R.id.text_container);
        mLeveledViewPager.setOffscreenPageLimit(adapter.getCount());
    }
}
