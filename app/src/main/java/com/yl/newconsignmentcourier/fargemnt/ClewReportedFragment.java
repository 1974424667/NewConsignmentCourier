package com.yl.newconsignmentcourier.fargemnt;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yl.newconsignmentcourier.R;


/**
 * Description:线索上报
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class ClewReportedFragment extends BaseFragment {

    private String TAG = "ClewReportedFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clewreported, container, false);
        RelativeLayout backspace = (RelativeLayout) view.findViewById(R.id.backspace);
        backspace.setVisibility(View.GONE);
        TextView mTitle = (TextView) view.findViewById(R.id.tv_title);
        mTitle.setText("线索上报");
        return view;
    }

    @Override
    protected void initTitle(TextView tvTitle) {

    }
}
