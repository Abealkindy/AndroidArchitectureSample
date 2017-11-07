package com.rosinante24.androidroomsample.listitems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante24.androidroomsample.db.SomethingModel;
import com.rosinante24.androidroomsample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 23/10/17.
 */

public class RecyclerSomethingAdapter extends RecyclerView.Adapter<RecyclerSomethingAdapter.ViewHolder> {
    private List<SomethingModel> somethingModelList;
    private View.OnLongClickListener longClickListener;

    public RecyclerSomethingAdapter(List<SomethingModel> somethingModelList, View.OnLongClickListener longClickListener) {
        this.somethingModelList = somethingModelList;
        this.longClickListener = longClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.something_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SomethingModel somethingModel = somethingModelList.get(position);
        holder.dateTextView.setText(somethingModel.getSomething_date().toLocaleString().substring(0, 11));
        holder.itemTextView.setText(somethingModel.getItem_name());
        holder.nameTextView.setText(somethingModel.getPerson_name());
        holder.itemView.setTag(somethingModel);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return somethingModelList.size();
    }

    public void addItem(List<SomethingModel> somethingModels) {
        this.somethingModelList = somethingModels;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemTextView)
        TextView itemTextView;
        @BindView(R.id.nameTextView)
        TextView nameTextView;
        @BindView(R.id.dateTextView)
        TextView dateTextView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
