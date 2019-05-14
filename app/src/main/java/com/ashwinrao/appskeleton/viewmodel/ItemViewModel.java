package com.ashwinrao.appskeleton.viewmodel;

import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.data.ItemRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class ItemViewModel extends ViewModel {

    private ItemRepository repo;

    ItemViewModel(ItemRepository repo) {
        this.repo = repo;
    }

    public LiveData<List<Item>> getItems() {
        return repo.getItems();
    }

    public void saveItem(Item item) {
        repo.saveItem(item);
    }

}
