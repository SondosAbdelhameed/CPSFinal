package com.cps.views.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.databinding.ActivityLoginBinding;
import com.cps.models.UserData;
import com.cps.models.requests.SendLogin;
import com.cps.models.responses.JsonResponse;
import com.cps.views.contact.ContactUs;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel viewModel;
    SendLogin sendLogin;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        sendLogin = new SendLogin();
        binding.setLogin(sendLogin);
        binding.setViewModel(viewModel);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));

        viewModel.liveData.observe(Login.this, new Observer<JsonResponse>() {
            @Override
            public void onChanged(JsonResponse response) {
                dialog.dismiss();
                if ( response.getStatus().getCode() == STATUS_CODE_SUCCESS){
                    Toast.makeText(Login.this, R.string.success, Toast.LENGTH_SHORT).show();
                    UserData user = new UserData(Login.this,response.getData().getUser());
                    user.setChildren(response.getData().getChildren());
                    finish();
                }else {
                    Toast.makeText(Login.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation(sendLogin)) {
                    dialog.show();
                    viewModel.login(sendLogin);
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
        if(login.getPassword() == null || login.getPassword() == "" ){
            c = false;
            binding.etPassword.setError(getString(R.string.error_empty_data));
        }
        return c;
    }
}
