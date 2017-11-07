package com.rosinante24.androidroomsample.additem;

import android.os.AsyncTask;

import com.rosinante24.androidroomsample.db.AppDatabase;
import com.rosinante24.androidroomsample.db.SomethingModel;

/**
 * Created by Rosinante24 on 23/10/17.
 */

class addAsyncTask extends AsyncTask<SomethingModel, Void, Void> {
    private AppDatabase db;

    public addAsyncTask(AppDatabase appDatabase) {
        db = appDatabase;
    }

    @Override
    protected Void doInBackground(SomethingModel... params) {
        db.itemAndPersonModel().addSomething(params[0]);
        return null;
    }
}
