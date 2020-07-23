package com.cps.views.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.adapters.ActivityAdapter;
import com.cps.databinding.ActivitySchoolBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.responses.ActivitiesItem;
import com.cps.models.responses.JsonResponse;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class SchoolActivity extends AppCompatActivity {

    ActivitySchoolBinding binding;
    ActivityAdapter adapter;
    ProgressDialog dialog;
    ActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_school);

        RecyclerView recyclerView = binding.rcvActivity;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();

        viewModel.liveData.observe(this, new Observer<JsonResponse>() {
            @Override
            public void onChanged(@Nullable JsonResponse response) {
                dialog.dismiss();
                if (response != null){

                    if (response.getStatus().getCode() == STATUS_CODE_SUCCESS){
                        Toast.makeText(SchoolActivity.this, R.string.success, Toast.LENGTH_SHORT).show();

                        adapter = new ActivityAdapter(response.getData().getActivities(),viewModel);
                        recyclerView.setAdapter(adapter);
                    }else if (response.getStatus().getCode() == STATUS_CODE_ERROR_TOKEN){
                        new GlobalFunction().userLogOut(SchoolActivity.this);
                    }else {
                        Toast.makeText(SchoolActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            dialog.dismiss();
            if (throwable == null) return;
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            binding.incErrorInternet.setVisibility(View.VISIBLE);
            binding.rcvActivity.setVisibility(View.GONE);
        });

        viewModel.request_activity(new UserData(this).getToken());
    }
}
