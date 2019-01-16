package com.ashwinrao.appskeleton.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase {

    private static final String TAG = "Room";

    private static ItemDatabase sInstance;
    public abstract ItemDao mDao();

    public static synchronized ItemDatabase getInstance(Context context) {
        if(sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), ItemDatabase.class, "Items.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

}
