package com.cps.views.profile;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.cps.R;
import com.cps.databinding.DialogChangePasswordBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.requests.SendEditPass;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class EditPasswordDialog extends DialogFragment {

    DialogChangePasswordBinding binding;
    ProfileViewModel viewModel;
    SendEditPass editPass;
    ProgressDialog dialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.dialog_change_password , container , false);
        editPass = new SendEditPass();
        binding.setPass(editPass);
        viewModel =  ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()) {
                    dialog.show();
                    viewModel.edit_pass(new UserData(getContext()).getToken(), editPass);
                }
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObservers();
    }

    private void initObservers() {
        viewModel.liveData.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(getActivity(), R.string.success, Toast.LENGTH_SHORT).show();
                    dismiss();
                    new GlobalFunction().userLogOut(getActivity());
                }else if (integer == STATUS_CODE_ERROR_TOKEN){
                new GlobalFunction().userLogOut(getActivity());
            }else {
                    Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        });

    }


    boolean validation(){
        boolean check = true;
            if (editPass.getOldPassword() == null || editPass.getOldPassword().isEmpty()) {
                binding.etOldPass.setError(getString(R.string.error_empty_data));
                check = false;
            }
            if (editPass.getNewPassword() == null || editPass.getNewPassword().isEmpty()) {
                binding.etNewPass.setError(getString(R.string.error_empty_data));
                check = false;
            }
        return check;
    }
}
