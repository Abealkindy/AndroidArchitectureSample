package com.rosinante24.androidroomsample.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Rosinante24 on 23/10/17.
 */
// anotasi Databse, digunakan untuk menyimpan semua database,
// didalam method tersebut ada entity, yg berarti array atau table dari database,
// lalu ada version yang berguna untuk menentukan versi dari database.
@Database(entities = {SomethingModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            // Room.databaseBuilder(),
            // berguna untuk membuat database lokal yang diisi/berdasarkan class, yang berisikan table atau arry dari database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "something_db")
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract SomethingModelDAO itemAndPersonModel();
}
