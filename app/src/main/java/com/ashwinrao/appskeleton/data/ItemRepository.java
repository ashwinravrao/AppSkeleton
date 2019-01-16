package com.ashwinrao.appskeleton.data;


import android.app.Application;
import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ItemRepository {

    private static final String TAG = "Room";

    private ItemDao mDao;
    private Context mContext;
    private static ItemRepository sInstance;

    public static ItemRepository getInstance(@NonNull Application application, ItemDatabase db) {
        if(sInstance == null) {
            sInstance = new ItemRepository(application, db);
        }
        return sInstance;
    }

    private ItemRepository(Application application, ItemDatabase db) {
        mContext = application.getApplicationContext();
        mDao = db.mDao();
    }

    public LiveData<List<Item>> getItems() {
        return mDao.getItems();
    }

    public void saveItem(Item item) {
        OneTimeWorkRequest saveItemRequest = new OneTimeWorkRequest.Builder(ItemSaveWorker.class).addTag("save item").build();
        WorkManager.getInstance().enqueue(saveItemRequest);
    }

    public class ItemSaveWorker extends Worker {

        private Item mItem;

        public ItemSaveWorker(@NonNull Context context, @NonNull WorkerParameters workerParams, @NonNull Item item) {
            super(context, workerParams);
            mItem = item;
        }

        @NonNull
        @Override
        public Result doWork() {
            mDao.saveItem(mItem);
            return Result.success();
        }
    }

}
