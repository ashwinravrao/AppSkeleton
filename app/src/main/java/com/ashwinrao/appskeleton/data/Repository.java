package com.ashwinrao.appskeleton.data;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface Repository {

    LiveData<List<Item>> getItems();

    void saveItem(Item item);

}
