package com.rosinante24.androidroomsample.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by Rosinante24 on 23/10/17.
 */
// untuk menunjukan bahwa kita membuat tabel berdasarkan Model/class ini.
@Entity
public class SomethingModel {
    // untuk menggenerate primary key secara auto.
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String item_name;
    private String person_name;
    // untuk mengkonversi tipe data melalui class DateConverter.java,
    // karena tipe data Date, tidak bisa langsung diolah oleh SQL.
    @TypeConverters(DateConverter.class)
    private Date something_date;

    public SomethingModel(String item_name, String person_name, Date something_date) {
        this.item_name = item_name;
        this.person_name = person_name;
        this.something_date = something_date;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getPerson_name() {
        return person_name;
    }

    public Date getSomething_date() {
        return something_date;
    }
}
