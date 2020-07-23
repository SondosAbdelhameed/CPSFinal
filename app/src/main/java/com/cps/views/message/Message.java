package com.cps.views.message;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.adapters.MessageAdapter;
import com.cps.databinding.ActivityMessageBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.responses.JsonResponse;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class Message extends AppCompatActivity {

    ActivityMessageBinding binding;
    MessageAdapter adapter;
    MessageViewModel viewModel;
    ProgressDialog dialog;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_message);

        RecyclerView recyclerView = binding.rcvMessage;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);

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
                        Toast.makeText(Message.this, R.string.success, Toast.LENGTH_SHORT).show();
                        try {
                            adapter = new MessageAdapter(response.getData().getMessages(),new UserData(Message.this).getId());
                            recyclerView.setAdapter(adapter);
                        } catch (Exception ex){
                            Log.d("Test",ex.toString());
                        }

                    }else if (response.getStatus().getCode() == STATUS_CODE_ERROR_TOKEN){
                        new GlobalFunction().userLogOut(Message.this);
                    }else {
                        Toast.makeText(Message.this, R.string.error, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        viewModel.sendLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
              //  dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(Message.this, R.string.success, Toast.LENGTH_SHORT).show();
                    binding.tvMessage.setText("");
                    viewModel.get_message(new UserData(Message.this).getToken());
                }else if (integer == STATUS_CODE_ERROR_TOKEN){
                    new GlobalFunction().userLogOut(Message.this);
                }else {
                    Toast.makeText(Message.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }

        });

        viewModel.errorLiveData.observe(this, throwable -> {
            dialog.dismiss();
            if (throwable == null) return;
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            binding.incErrorInternet.setVisibility(View.VISIBLE);
            binding.rcvMessage.setVisibility(View.GONE);
        });

        viewModel.get_message(new UserData(this).getToken());

        binding.imgSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    dialog.show();
                    viewModel.send_message(new UserData(Message.this).getToken(),message);
                }
            }
        });

    }

    boolean validation(){
        boolean check = true;
        message = binding.tvMessage.getText().toString();
        if(message.isEmpty()){
            binding.tvMessage.setError(getString(R.string.error_empty_data));
            check = false;
        }
        return check;
    }
}
