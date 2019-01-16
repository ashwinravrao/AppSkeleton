package com.ashwinrao.appskeleton;

import android.app.Application;

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
        return ItemDatabase.getInstance(this);
    }

    public ItemRepository getRepository() {
        return ItemRepository.getInstance(getDatabase());
    }
}
