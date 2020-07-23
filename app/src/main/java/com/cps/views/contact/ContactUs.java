package com.cps.views.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.databinding.ActivityContactUsBinding;
import com.cps.models.requests.SendContact;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class ContactUs extends AppCompatActivity {

    ActivityContactUsBinding binding;
    ContactUsViewModel viewModel;
    SendContact contact;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_contact_us);
        viewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);
        contact = new SendContact();
        binding.setViewModel(viewModel);
        binding.setContact(contact);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));

        viewModel.liveData.observe(ContactUs.this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(ContactUs.this, R.string.success, Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(ContactUs.this, R.string.error, Toast.LENGTH_SHORT).show();
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
                if(validation(contact)) {
                    dialog.show();
                    viewModel.send_contact(contact);

                }
            }
        });
    }

    boolean validation(SendContact contact){
        boolean c = true;
        if(contact.getEmail() == "" || contact.getEmail() == null) {
            c = false;
            binding.etEmail.setError(getString(R.string.error_empty_data));
        }else if(!Patterns.EMAIL_ADDRESS.matcher(contact.getEmail()).matches()){
            c = false;
            binding.etEmail.setError(getString(R.string.error_email_format));
        }
        if(contact.getMessage() == "" || contact.getMessage() == null){
            c = false;
            binding.etMessage.setError(getString(R.string.error_empty_data));
        }
        if(contact.getName() == "" || contact.getName() == null){
            c = false;
            binding.etName.setError(getString(R.string.error_empty_data));
        }
        if(contact.getPhone() == "" || contact.getPhone() == null){
            c = false;
            binding.etPhone.setError(getString(R.string.error_empty_data));
        }
        if(contact.getSubject() == "" || contact.getSubject() == null){
            c = false;
            binding.etSubject.setError(getString(R.string.error_empty_data));
        }
        return c;
    }
}
