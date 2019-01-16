package com.ashwinrao.appskeleton.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ItemViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static ItemViewModelFactory sInstance;
    private Application mApplication;

    public static synchronized ItemViewModelFactory getInstance(@NonNull Application application) {
        if(sInstance == null) {
            sInstance = new ItemViewModelFactory(application);
        }
        return sInstance;
    }

    private ItemViewModelFactory(@NonNull Application application) {
        super();
        mApplication = application;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ItemViewModel(mApplication);
    }
}
