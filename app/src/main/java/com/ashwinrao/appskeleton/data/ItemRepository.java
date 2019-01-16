package com.ashwinrao.appskeleton.data;


import com.ashwinrao.appskeleton.util.AsyncTasks;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ItemRepository {

    private static final String TAG = "Room";

    private ItemDao mDao;
    private static ItemRepository sInstance;

    public static ItemRepository getInstance(ItemDatabase db) {
        if(sInstance == null) {
            sInstance = new ItemRepository(db);
        }
        return sInstance;
    }

    private ItemRepository(ItemDatabase db) {
        mDao = db.mDao();
    }

    public LiveData<List<Item>> getItems() {
        return mDao.getItems();
    }

    public void saveItem(Item item) {
        new AsyncTasks.SavePersonAsync(mDao).execute(item);
    }



}
