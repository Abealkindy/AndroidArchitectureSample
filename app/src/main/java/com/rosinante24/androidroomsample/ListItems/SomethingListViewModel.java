package com.rosinante24.androidroomsample.ListItems;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rosinante24.androidroomsample.DB.AppDatabase;
import com.rosinante24.androidroomsample.DB.SomethingModel;

import java.util.List;

/**
 * Created by Rosinante24 on 23/10/17.
 */

public class SomethingListViewModel extends AndroidViewModel {
    private final LiveData<List<SomethingModel>> itemAndPersonList;
    private AppDatabase appDatabase;

    public SomethingListViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        itemAndPersonList = appDatabase.itemAndPersonModel().getAllSomethingItems();
    }

    public LiveData<List<SomethingModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    public void deleteItem(SomethingModel somethingModel) {
        new deleteAsyncTask(appDatabase).execute(somethingModel);
    }

}
