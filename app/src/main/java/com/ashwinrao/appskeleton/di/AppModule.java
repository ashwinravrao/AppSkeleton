package com.ashwinrao.appskeleton.di;

import android.app.Application;

import com.ashwinrao.appskeleton.AppSkeleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final AppSkeleton application;

    public AppModule(AppSkeleton application) {
        this.application = application;
    }

    @Provides
    AppSkeleton provideAppSkeleton() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

}
