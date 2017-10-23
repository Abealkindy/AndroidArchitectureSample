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
// ViewModel dari aplikasi ini yang berguna sebagai pembantu dalam mengatur dan menampilkan list yang kita buat,
// ViewModel ini harus extend kepada AndroidViewModel,
// dan harus terbebas dari semua yang berhubungan dengan UI, seperti Activity, dan Fragment,
// dan ViewModel ini berisikan semua yang dibutuhkan oleh MainActivity, dan sekarang kita hubungkan dengan LiveData
public class SomethingListViewModel extends AndroidViewModel {

    // LiveData adalah pembungkus data, yang memungkinkan Class yang akan terhubung, mengikuti perubahan data dari LiveData
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
