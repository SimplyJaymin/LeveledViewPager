package com.android.jminlabs.leveledviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jayminraval on 2017-05-08.
 */
public class LeveledViewPager extends ViewPager {

    private int mSameHeightViewId = 0;
    private boolean mAdjustmentDone = false;

    public LeveledViewPager(Context context) {
        super(context);
    }

    public LeveledViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setViewIdToLevel(int id) {
        mSameHeightViewId = id;
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);

        if (!mAdjustmentDone && mSameHeightViewId != 0) {
            int maxHeight = 0;
            if (getAdapter() instanceof FragmentPagerAdapter) {
                FragmentPagerAdapter fragmentPagerAdapter = (FragmentPagerAdapter) getAdapter();

                //Loop through all the fragments to get the max height of the view to be leveled
                for (int count = 0; count < fragmentPagerAdapter.getCount(); count++) {
                    Fragment fragment = fragmentPagerAdapter.getItem(count);
                    int height = 0;
                    View fragmentView = fragment.getView();
                    if (fragmentView != null) {
                        View view = fragmentView.findViewById(mSameHeightViewId);
                        if(view != null) {
                            height = view.getMeasuredHeight();
                            if (height > maxHeight) {
                                maxHeight = height;
                            }
                        }
                    }
                }

                //Loop through all the fragments to set the height of the view to be leveled
                for (int count = 0; count < fragmentPagerAdapter.getCount(); count++) {
                    Fragment fragment = fragmentPagerAdapter.getItem(count);
                    View fragmentView = fragment.getView();
                    if (fragmentView != null) {
                        View view = fragmentView.findViewById(mSameHeightViewId);
                        if (view != null) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = maxHeight;
                            view.setLayoutParams(layoutParams);
                        }
                    }
                    mAdjustmentDone = true;
                }
            }
        }
    }
}
