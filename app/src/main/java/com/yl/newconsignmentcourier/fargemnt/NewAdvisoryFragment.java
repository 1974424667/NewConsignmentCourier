package com.yl.newconsignmentcourier.fargemnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javonlee.dragpointview.view.DragPointView;
import com.yl.newconsignmentcourier.R;

/**
 * Description:新闻咨询
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class NewAdvisoryFragment extends BaseFragment implements View.OnClickListener {
    private String TAG = "NewAdvisoryFragment";
    private RelativeLayout mRlMissage;
    private DragPointView mPointView;
    private ImageView mImfoMissage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newadvisory, container, false);
        TextView mTitle = (TextView) view.findViewById(R.id.tv_title);
        mTitle.setText("新闻咨询");
        RelativeLayout backspace = (RelativeLayout) view.findViewById(R.id.backspace);
        backspace.setVisibility(View.GONE);
        mImfoMissage = (ImageView) view.findViewById(R.id.imfo_missage);
        mRlMissage = (RelativeLayout) view.findViewById(R.id.rl_missage);
        mPointView = (DragPointView) view.findViewById(R.id.drag_point_view);
        //小红点塞值
        initDataDragPointView(26);

        mRlMissage.setOnClickListener(this);
        mPointView.setOnClickListener(this);
        mImfoMissage.setOnClickListener(this);
        return view;
    }

    private void initDataDragPointView(int data) {
        if (data > 99) {
            mPointView.setText(data + "+");
            mPointView.setVisibility(View.VISIBLE);
        } else if (data < 99 && data > 0) {
            mPointView.setText(data + "");
            mPointView.setVisibility(View.VISIBLE);
        } else {
            mPointView.setText("");
            mPointView.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void initTitle(TextView tvTitle) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imfo_missage:
            case R.id.rl_missage:
            case R.id.drag_point_view:
                initDataDragPointView(0);
                break;
        }
    }
}
