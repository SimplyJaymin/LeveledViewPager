package com.android.sample.jminlabs.sameheightviewpagertest;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayminraval on 2017-05-08.
 */

public class PageFragment extends Fragment {

    private static final String BUNDLE_ARG_DESCRIPTION_TEXT = "DESCRIPTION_TEXT";
    private static final String BUNDLE_ARG_TOP_VIEW_COLOR_ID = "TOP_VIEW_COLOR_ID";

    private String mDescriptionText;
    private int mTopViewColorId;

    @BindView(R.id.text_description)
    TextView mDescriptionView;

    @BindView(R.id.top_view)
    View mTopView;

    public static PageFragment newInstance(@IdRes int topViewColorResourceId, String descriptionText) {
        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ARG_DESCRIPTION_TEXT, descriptionText);
        bundle.putInt(BUNDLE_ARG_TOP_VIEW_COLOR_ID, topViewColorResourceId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mDescriptionText = bundle.getString(BUNDLE_ARG_DESCRIPTION_TEXT);
        mTopViewColorId = bundle.getInt(BUNDLE_ARG_TOP_VIEW_COLOR_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page, container, false);
        ButterKnife.bind(this, rootView);
        initViews();
        return rootView;
    }

    private void initViews() {
        mDescriptionView.setText(mDescriptionText);
        mTopView.setBackgroundColor(mTopViewColorId);
    }
}
