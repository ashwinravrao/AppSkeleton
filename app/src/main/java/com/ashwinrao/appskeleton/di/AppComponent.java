package com.ashwinrao.appskeleton.di;

import android.app.Application;

import com.ashwinrao.appskeleton.view.ui.AddItemFragment;
import com.ashwinrao.appskeleton.view.ui.DetailEditFragment;
import com.ashwinrao.appskeleton.view.ui.ItemListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DbModule.class})
public interface AppComponent {

    void inject(ItemListFragment fragment);
    void inject(AddItemFragment fragment);
    void inject(DetailEditFragment fragment);

//    Application application();

}
