package com.rosinante24.androidroomsample.DB;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Rosinante24 on 23/10/17.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timeStamp) {
        return timeStamp == null ? null : new Date(timeStamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
