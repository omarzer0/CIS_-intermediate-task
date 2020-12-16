package com.azapps.cis_intermediate_task.adapter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.azapps.cis_intermediate_task.ui.FirstSliderFragment;
import com.azapps.cis_intermediate_task.ui.SecondSliderFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) fragment = new FirstSliderFragment();
        else fragment = new SecondSliderFragment();
        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }
}