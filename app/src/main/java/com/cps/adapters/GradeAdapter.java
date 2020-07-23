package com.cps.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.databinding.ItemResultBinding;
import com.cps.models.responses.GradesItem;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.viewHolder> {

    List<GradesItem> gradesItems;

    public GradeAdapter(List<GradesItem> gradesItems) {
        this.gradesItems = gradesItems;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResultBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_result, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GradesItem item = gradesItems.get(position);
        holder.binding.setGrades(item);

    }

    @Override
    public int getItemCount() {
        if(gradesItems != null)
            return gradesItems.size();
        else
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ItemResultBinding binding;
        public viewHolder(@NonNull ItemResultBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
