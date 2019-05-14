package com.ashwinrao.appskeleton.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase {

    public abstract ItemDao mDao();

}
