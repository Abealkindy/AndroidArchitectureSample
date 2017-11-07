package com.rosinante24.androidroomsample.additem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.rosinante24.androidroomsample.db.AppDatabase;
import com.rosinante24.androidroomsample.db.SomethingModel;

/**
 * Created by Rosinante24 on 23/10/17.
 */

public class AddSomethingViewModel extends AndroidViewModel {
    private AppDatabase appDatabase;

    public AddSomethingViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void addSomething(final SomethingModel somethingModel) {
        new addAsyncTask(appDatabase).execute(somethingModel);
    }
}
