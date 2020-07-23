package com.cps.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.databinding.ItemActivityBinding;
import com.cps.models.responses.ActivitiesItem;
import com.cps.views.activity.ActivityViewModel;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.viewHolder>{

    List<ActivitiesItem> items;
    ActivityViewModel viewModel;

    public ActivityAdapter(List<ActivitiesItem> items, ActivityViewModel viewModel) {
        this.items = items;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemActivityBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_activity, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ActivitiesItem item = items.get(position);
        holder.binding.setActivity(item);
        holder.binding.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ItemActivityBinding binding;
        public viewHolder(@NonNull ItemActivityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
