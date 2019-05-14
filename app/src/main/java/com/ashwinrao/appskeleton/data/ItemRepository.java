package com.ashwinrao.appskeleton.data;

import com.ashwinrao.appskeleton.util.AsyncTasks;

import java.util.List;

import androidx.lifecycle.LiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemRepository implements Repository {

    private static final String TAG = "Room";
    private ItemDao dao;

    @Inject
    public ItemRepository(ItemDatabase db) {
        dao = db.mDao();
    }

    public LiveData<List<Item>> getItems() {
        return dao.getItems();
    }

    public void saveItem(Item item) {
        new AsyncTasks.SavePersonAsync(dao).execute(item);
    }

}
