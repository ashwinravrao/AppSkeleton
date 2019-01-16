package com.ashwinrao.appskeleton.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class ItemDatabase extends RoomDatabase {

    public static final String TAG = "Room";

    private static ItemDatabase sInstance;
    public abstract ItemDao mDao();

    public static synchronized ItemDatabase getInstance(Context context) {
        if(sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), ItemDatabase.class, "Items.db")
                    .fallbackToDestructiveMigration()
                    .build();
            Log.d(TAG, "getInstance: new db instance created");
        }
        Log.d(TAG, "getInstance: db instance returned");
        return sInstance;
    }

}
