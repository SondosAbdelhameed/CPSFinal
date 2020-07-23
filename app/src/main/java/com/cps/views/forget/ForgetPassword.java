package com.cps.views.forget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.databinding.ActivityForgetPasswordBinding;
import com.cps.models.requests.SendLogin;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class ForgetPassword extends AppCompatActivity {

    ActivityForgetPasswordBinding binding;
    ForgetPasswordViewModel viewModel;
    SendLogin sendLogin;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_forget_password);
        viewModel = ViewModelProviders.of(this).get(ForgetPasswordViewModel.class);
        sendLogin = new SendLogin();
        binding.setLogin(sendLogin);
       // binding.setViewModel(viewModel);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));

        viewModel.liveData.observe(ForgetPassword.this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(ForgetPassword.this, R.string.success, Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(ForgetPassword.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation(sendLogin)) {
                    dialog.show();
                    viewModel.forget_password(sendLogin);
                }
            }
        });

    }

    boolean validation(SendLogin login){
        boolean c = true;
        if(login.getEmail() == null || login.getEmail() == "" ) {
            c = false;
            binding.etEmail.setError(getString(R.string.error_empty_data));
        }else if(!Patterns.EMAIL_ADDRESS.matcher(login.getEmail()).matches()){
            c = false;
            binding.etEmail.setError(getString(R.string.error_email_format));
        }
        return c;
    }
}
