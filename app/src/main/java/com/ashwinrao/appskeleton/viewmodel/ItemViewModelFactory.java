package com.ashwinrao.appskeleton.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ashwinrao.appskeleton.data.ItemRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemViewModelFactory implements ViewModelProvider.Factory {

    private final ItemRepository repo;

    @Inject
    public ItemViewModelFactory(@NonNull ItemRepository repo) {
        this.repo = repo;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ItemViewModel(this.repo);
    }
}
