package com.cps.views.gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.adapters.GalleryAdapter;
import com.cps.databinding.ActivityGalleryBinding;
import com.cps.models.responses.GalleryItem;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Gallery extends AppCompatActivity {

    GalleryViewModel viewModel;
    GalleryAdapter adapter;
    ActivityGalleryBinding binding;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_gallery);

        RecyclerView recyclerView = binding.rcvGallery;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();

        adapter = new GalleryAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.galleryLiveData.observe(this, new Observer<List<GalleryItem>>() {
            @Override
            public void onChanged(@Nullable List<GalleryItem> items) {
                dialog.dismiss();
                if (items != null){
                    Toast.makeText(Gallery.this, "Success", Toast.LENGTH_SHORT).show();
                    adapter.setItems(items);

                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            binding.incErrorInternet.setVisibility(View.VISIBLE);
            binding.rcvGallery.setVisibility(View.GONE);
        });

        viewModel.request_gallery();
    }
}
