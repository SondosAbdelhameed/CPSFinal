package com.cps.views.notification;

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
import com.cps.adapters.NotificationAdapter;
import com.cps.databinding.ActivityNotificationBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.responses.JsonResponse;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class Notification extends AppCompatActivity {

    ProgressDialog dialog;
    ActivityNotificationBinding binding;
    NotificationAdapter adapter;
    NotificationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification);

        viewModel = ViewModelProviders.of(this).get(NotificationViewModel.class);

        RecyclerView recyclerView = binding.rcvNotification;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


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
                        Toast.makeText(Notification.this, R.string.success, Toast.LENGTH_SHORT).show();

                        adapter = new NotificationAdapter(response.getData().getNotification(),viewModel);
                        recyclerView.setAdapter(adapter);
                    }else if (response.getStatus().getCode() == STATUS_CODE_ERROR_TOKEN){
                        new GlobalFunction().userLogOut(Notification.this);
                    }else {
                        Toast.makeText(Notification.this, R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            dialog.dismiss();
            if (throwable == null) return;
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            binding.incErrorInternet.setVisibility(View.VISIBLE);
            binding.rcvNotification.setVisibility(View.GONE);
        });


        if (new UserData(this).isLoged())
            viewModel.notification_after(new UserData(this).getToken());
        else
            viewModel.notification_before();
    }
}
