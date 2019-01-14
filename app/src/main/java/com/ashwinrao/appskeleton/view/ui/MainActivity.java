package com.ashwinrao.appskeleton.view.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentHost {

    @Override
    public Fragment createFragment() {
        return new ItemListFragment();
    }

    public static void transact(@NonNull Fragment newFragment) {
        mFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(mFragmentContainer, newFragment)
                .commit();
    }
}
