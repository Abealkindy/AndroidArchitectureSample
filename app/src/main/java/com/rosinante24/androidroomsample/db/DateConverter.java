package com.rosinante24.androidroomsample.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Rosinante24 on 23/10/17.
 */

public class DateConverter {
    // mengkonversi data yang didapat dari model menjadi Long
    @TypeConverter
    public static Date toDate(Long timeStamp) {
        return timeStamp == null ? null : new Date(timeStamp);
    }

    // mengkonversi data kembali, dari Long menjadi Date, setelah disimpan
    @TypeConverter
    public static Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
