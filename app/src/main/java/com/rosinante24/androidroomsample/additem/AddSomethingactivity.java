package com.rosinante24.androidroomsample.additem;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.rosinante24.androidroomsample.db.SomethingModel;
import com.rosinante24.androidroomsample.R;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddSomethingactivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.edit_text_item_name)
    EditText editTextItemName;
    @BindView(R.id.edit_text_person_name)
    EditText editTextPersonName;
    @BindView(R.id.button_select_date)
    Button buttonSelectDate;
    @BindView(R.id.fab_done)
    FloatingActionButton fabDone;
    private Date date;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private AddSomethingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_somethingactivity);
        ButterKnife.bind(this);
        calendar = Calendar.getInstance();
        viewModel = ViewModelProviders.of(this).get(AddSomethingViewModel.class);
        datePickerDialog = new DatePickerDialog(this, AddSomethingactivity.this, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    @OnClick({R.id.button_select_date, R.id.fab_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_select_date:
                datePickerDialog.show();
                break;
            case R.id.fab_done:
                String item_name = editTextItemName.getText().toString();
                String person_name = editTextPersonName.getText().toString();
                if (item_name.isEmpty()) {
                    editTextItemName.setError("Fill your item name!");
                    editTextItemName.requestFocus();
                } else if (person_name.isEmpty()) {
                    editTextPersonName.setError("Fill your person name!");
                    editTextPersonName.requestFocus();
                } else if (date == null) {
                    Toast.makeText(this, "Select your date!", Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.addSomething(
                            new SomethingModel(
                                    item_name,
                                    person_name,
                                    date
                            )
                    );
                    finish();
                }
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();
    }
}
