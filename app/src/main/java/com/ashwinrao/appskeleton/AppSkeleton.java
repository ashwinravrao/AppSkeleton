package com.ashwinrao.appskeleton;

import android.app.Application;
import android.util.Log;

import com.ashwinrao.appskeleton.data.ItemDatabase;
import com.ashwinrao.appskeleton.data.ItemRepository;
import com.ashwinrao.appskeleton.view.ui.MainActivity;

public class AppSkeleton extends Application {

    private static final String TAG = MainActivity.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ItemDatabase getDatabase() {
        Log.d(TAG, "AppSkeleton: getDatabase() called");
        return ItemDatabase.getInstance(this);
    }

    public ItemRepository getRepository() {
        Log.d(TAG, "AppSkeleton: getRepository() called");
        return ItemRepository.getInstance(getDatabase());
    }
}
