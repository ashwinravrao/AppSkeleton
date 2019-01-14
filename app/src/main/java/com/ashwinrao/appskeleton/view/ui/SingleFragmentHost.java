package com.ashwinrao.appskeleton.view.ui;

import android.os.Bundle;

import com.ashwinrao.appskeleton.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentHost extends AppCompatActivity {

    public static FragmentManager mFragmentManager;

    public static int mFragmentContainer;

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfh);

        mFragmentManager = getSupportFragmentManager();
        mFragmentContainer = R.id.fragment_container;
        Fragment fragment = mFragmentManager.findFragmentById(mFragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            mFragmentManager.beginTransaction().add(mFragmentContainer, fragment).commit();
        }
    }
}
