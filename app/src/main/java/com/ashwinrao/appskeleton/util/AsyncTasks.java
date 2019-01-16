package com.ashwinrao.appskeleton.util;

import android.os.AsyncTask;

import com.ashwinrao.appskeleton.data.Item;
import com.ashwinrao.appskeleton.data.ItemDao;

public class AsyncTasks {

    public static class SavePersonAsync extends AsyncTask<Item, Void, Void> {

        private ItemDao mItemDao;

        public SavePersonAsync(ItemDao itemDao) {
            mItemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            mItemDao.saveItem(items[0]);
            return null;
        }
    }
}
