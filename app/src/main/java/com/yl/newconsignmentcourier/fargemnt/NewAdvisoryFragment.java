package com.yl.newconsignmentcourier.fargemnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itingchunyu.badgeview.BaseBadgeView;
import com.yl.newconsignmentcourier.R;

/**
 * Description:新闻咨询
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class NewAdvisoryFragment extends BaseFragment {
    private String TAG = "NewAdvisoryFragment";
    private BaseBadgeView mBtvMissage;
    private RelativeLayout mRlMissage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newadvisory, container, false);
        TextView mTitle = (TextView) view.findViewById(R.id.tv_title);
        mTitle.setText("新闻咨询");
        RelativeLayout backspace = (RelativeLayout) view.findViewById(R.id.backspace);
        backspace.setVisibility(View.GONE);
        mRlMissage = (RelativeLayout) view.findViewById(R.id.rl_missage);
        mBtvMissage = (BaseBadgeView) view.findViewById(R.id.btv_missage);
        mBtvMissage.setVisibility(View.VISIBLE);
        mBtvMissage.setBadgeCount(8);
        return view;
    }

    @Override
    protected void initTitle(TextView tvTitle) {

    }
}
