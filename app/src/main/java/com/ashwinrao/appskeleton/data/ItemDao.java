package com.ashwinrao.appskeleton.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ItemDao {

    @Query("select * from items")
    LiveData<List<Item>> getItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveItem(Item item);

}
