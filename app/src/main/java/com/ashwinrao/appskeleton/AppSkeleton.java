package com.ashwinrao.appskeleton;

import android.app.Application;

import com.ashwinrao.appskeleton.di.AppComponent;
import com.ashwinrao.appskeleton.di.AppModule;
import com.ashwinrao.appskeleton.di.DaggerAppComponent;
import com.ashwinrao.appskeleton.di.DbModule;


public class AppSkeleton extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().dbModule(new DbModule(this)).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
