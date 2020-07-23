package com.cps.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.databinding.ItemEventNewsBinding;
import com.cps.models.responses.EventsNewsItem;
import com.cps.views.events_news.EventNewsViewModel;

import java.util.List;

public class EventNewsAdapter extends RecyclerView.Adapter<EventNewsAdapter.viewHolder> {

    List<EventsNewsItem> items;
    EventNewsViewModel viewModel;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemEventNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_event_news, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        EventsNewsItem item = items.get(position);
        holder.binding.setNews(item);
        holder.binding.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        if(items != null)
            return items.size();
        else
            return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ItemEventNewsBinding binding;
        public viewHolder(@NonNull ItemEventNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setItems(List<EventsNewsItem> items , EventNewsViewModel viewModel) {
        this.items = items;
        this.viewModel = viewModel;
        notifyDataSetChanged();
    }

}
