package com.rosinante24.androidroomsample.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rosinante24 on 23/10/17.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface SomethingModelDAO {

    @Query("SELECT * FROM SomethingModel")
    LiveData<List<SomethingModel>> getAllSomethingItems();

    @Query("SELECT * FROM SomethingModel WHERE id = :id")
    SomethingModel getItemById(String id);

    @Insert(onConflict = REPLACE)
    void addSomething(SomethingModel somethingModel);

    @Delete
    void deleteSomething(SomethingModel somethingModel);

}
