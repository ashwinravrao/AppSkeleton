package com.ashwinrao.appskeleton.view.ui;

import android.os.Bundle;

import com.ashwinrao.appskeleton.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager mFragmentManager;

    public static final int mFragmentContainer = R.id.fragment_container;

    public Fragment createFragment() {
        return new ItemListFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfh);

        // Install fragment in empty host view
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(mFragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            mFragmentManager.beginTransaction().add(mFragmentContainer, fragment).commit();
        }
    }

    public static void doFragmentTransaction(@NonNull Fragment newFragment) {
        mFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(mFragmentContainer, newFragment)
                .commit();
    }
}
