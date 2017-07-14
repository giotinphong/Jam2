package com.swings.jam.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class FragmentPageAdapter extends FragmentStatePagerAdapter {
    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();

            case 1:
                return new FavoriteFragment();

            case 2:
                return new YourJamFragment();

        }
    return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Trang chủ";

            case 1:
                return "Yêu thích";

            case 2:
                return "Your Jam";

        }
        return null;    }

    @Override
    public int getCount() {
        return 3;
    }
}
