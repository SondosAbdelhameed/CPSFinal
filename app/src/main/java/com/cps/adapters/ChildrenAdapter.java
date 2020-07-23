package com.cps.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.databinding.ItemChildBinding;
import com.cps.models.responses.ChildrenItem;
import com.cps.views.profile.ProfileViewModel;

import java.util.List;

public class ChildrenAdapter extends RecyclerView.Adapter<ChildrenAdapter.viewHolder> {

    List<ChildrenItem> childrenItems;
    ProfileViewModel viewModel;

    public ChildrenAdapter(List<ChildrenItem> childrenItems, ProfileViewModel viewModel) {
        this.childrenItems = childrenItems;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChildBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_child, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChildrenItem item = childrenItems.get(position);
        holder.binding.setChild(item);
        holder.binding.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        if(childrenItems != null)
            return childrenItems.size();
        else
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ItemChildBinding binding;
        public viewHolder(@NonNull ItemChildBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

   /* public void setItems(List<ChildrenItem> items , ProfileViewModel viewModel) {
        this.childrenItems = items;
        this.viewModel = viewModel;
        notifyDataSetChanged();
    }*/
}
