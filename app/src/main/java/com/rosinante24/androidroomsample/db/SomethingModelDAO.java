package com.rosinante24.androidroomsample.db;

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
// DAO (Data Access Object), kelas yang akan digunakan untuk mendefinisikan semua query yang akan berjalan
@Dao
@TypeConverters(DateConverter.class)
public interface SomethingModelDAO {

    // anotasi Query, digunakan untuk membuat query/perintah kepada database lokal saat aplikasi dijalankan
    @Query("SELECT * FROM SomethingModel")
    LiveData<List<SomethingModel>> getAllSomethingItems();

    @Query("SELECT * FROM SomethingModel WHERE id = :id")
    SomethingModel getItemById(String id);

    // anotasi Insert, digunakan untuk memasukkan data ke dalam table,
    // dan disini method diisi dengan onConflict, yang bertujuan untuk mencegah konfllik data
    @Insert(onConflict = REPLACE)
    void addSomething(SomethingModel somethingModel);

    // anotasi Delete, digunakan untuk menghapus data
    @Delete
    void deleteSomething(SomethingModel somethingModel);

}
