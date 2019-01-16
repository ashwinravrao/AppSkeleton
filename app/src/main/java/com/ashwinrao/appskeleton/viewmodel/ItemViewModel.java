package com.ashwinrao.appskeleton.viewmodel;

import android.app.Application;

import com.ashwinrao.appskeleton.AppSkeleton;
import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.data.ItemRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private static final String TAG = "Room";
    private final ItemRepository mRepository;

    public ItemViewModel(@NonNull Application application) {
        mRepository = ((AppSkeleton) application).getRepository();
    }

    public LiveData<List<Item>> getItems() {
        return mRepository.getItems();
    }

    public void saveItem(Item item) {
        mRepository.saveItem(item);
    }

}
