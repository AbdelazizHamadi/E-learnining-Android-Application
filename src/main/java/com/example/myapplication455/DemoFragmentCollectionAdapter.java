package com.example.myapplication455;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public DemoFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        DemoFragment demoFragment = new DemoFragment();

        Bundle bundle = new Bundle();
        i = i+1;

        bundle.putString("Message","Hello from page : " + i);
        demoFragment.setArguments(bundle);


        return null;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
