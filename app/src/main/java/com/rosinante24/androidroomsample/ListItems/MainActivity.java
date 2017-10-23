package com.rosinante24.androidroomsample.ListItems;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rosinante24.androidroomsample.AddItem.AddSomethingactivity;
import com.rosinante24.androidroomsample.DB.SomethingModel;
import com.rosinante24.androidroomsample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_something)
    RecyclerView listSomething;
    @BindView(R.id.fab_add_something)
    FloatingActionButton fabAddSomething;

    private RecyclerSomethingAdapter adapter;
    private SomethingListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new RecyclerSomethingAdapter(new ArrayList<SomethingModel>(), this);
        listSomething.setLayoutManager(new LinearLayoutManager(this));
        listSomething.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(SomethingListViewModel.class);
        viewModel.getItemAndPersonList().observe(MainActivity.this, new Observer<List<SomethingModel>>() {
            @Override
            public void onChanged(@Nullable List<SomethingModel> somethingModels) {
                adapter.addItem(somethingModels);
            }
        });
    }


    @OnClick(R.id.fab_add_something)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, AddSomethingactivity.class));
    }

    @Override
    public boolean onLongClick(View v) {
        SomethingModel somethingModel = (SomethingModel) v.getTag();
        viewModel.deleteItem(somethingModel);
        return true;
    }
}
