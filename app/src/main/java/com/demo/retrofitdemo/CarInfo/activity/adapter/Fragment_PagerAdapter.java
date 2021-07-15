package com.demo.retrofitdemo.CarInfo.activity.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.demo.retrofitdemo.CarInfo.activity.modal.FragmentModel;

import java.util.ArrayList;

public class Fragment_PagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    ArrayList<FragmentModel> fragmentModel;

    public Fragment_PagerAdapter(@NonNull FragmentManager fm, ArrayList<FragmentModel> fragmentModel) {
        super(fm);
        this.fragmentModel = fragmentModel;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentModel.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentModel.size();
    }
}
