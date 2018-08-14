package com.yl.newconsignmentcourier.factory;

import com.yl.newconsignmentcourier.fargemnt.BaseFragment;
import com.yl.newconsignmentcourier.fargemnt.ClewReportedFragment;
import com.yl.newconsignmentcourier.fargemnt.InformationCollectionFragment;
import com.yl.newconsignmentcourier.fargemnt.NewAdvisoryFragment;
import com.yl.newconsignmentcourier.fargemnt.PersonalInformationFragment;

import java.util.HashMap;

/**
 * Description:Fragment静态工厂类
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class FragmentFactory {
    private static HashMap<Integer, BaseFragment> savedFragment = new HashMap<>();

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = savedFragment.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new NewAdvisoryFragment();
                    break;
                case 1:
                    fragment = new ClewReportedFragment();
                    break;
                case 2:
                    fragment = new InformationCollectionFragment();
                    break;
                case 3:
                    fragment = new PersonalInformationFragment();
                    break;
            }
            savedFragment.put(position, fragment);
        }
        return fragment;
    }
}
