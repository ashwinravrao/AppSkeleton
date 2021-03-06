package com.ashwinrao.appskeleton.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import com.ashwinrao.appskeleton.R;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager mFragmentManager;

    public static final int mFragmentContainer = R.id.fragment_container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Install fragment in empty host view
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(mFragmentContainer);
        if (fragment == null) {
            fragment = new ItemListFragment();
            mFragmentManager.beginTransaction().add(mFragmentContainer, fragment).commit();
        }
    }

    public static void doFragmentTransaction(@NonNull Fragment newFragment) {
        mFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(mFragmentContainer, newFragment)
                .commit();
    }

    public static List<Fragment> getAttachedFragments() {
        return mFragmentManager.getFragments();
    }

    public static void popBackStack() {
        mFragmentManager.popBackStack();
    }
}
