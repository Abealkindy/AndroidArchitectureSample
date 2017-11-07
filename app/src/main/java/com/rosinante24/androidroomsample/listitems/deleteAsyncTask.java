package com.rosinante24.androidroomsample.listitems;

import android.os.AsyncTask;

import com.rosinante24.androidroomsample.db.AppDatabase;
import com.rosinante24.androidroomsample.db.SomethingModel;

/**
 * Created by Rosinante24 on 23/10/17.
 */

class deleteAsyncTask extends AsyncTask<SomethingModel, Void, Void> {
    private AppDatabase db;

    public deleteAsyncTask(AppDatabase appDatabase) {
        db = appDatabase;
    }

    @Override
    protected Void doInBackground(final SomethingModel... params) {
        db.itemAndPersonModel().deleteSomething(params[0]);
        return null;
    }
}
