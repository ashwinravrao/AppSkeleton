package com.ashwinrao.appskeleton.di;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.ashwinrao.appskeleton.data.ItemDao;
import com.ashwinrao.appskeleton.data.ItemDatabase;
import com.ashwinrao.appskeleton.data.ItemRepository;
import com.ashwinrao.appskeleton.viewmodel.ItemViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    private final ItemDatabase database;

    public DbModule(Application application) {
        this.database = Room.databaseBuilder(application.getApplicationContext(),
                ItemDatabase.class,
                "Items.db"
        )
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    ItemRepository provideRepository() {
        return new ItemRepository(database);
    }

    @Provides
    ItemDao provideDao() {
        return database.mDao();
    }

    @Provides
    ItemDatabase provideDatabase() {
        return database;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ItemRepository repository) {
        return new ItemViewModelFactory(repository);
    }
}
