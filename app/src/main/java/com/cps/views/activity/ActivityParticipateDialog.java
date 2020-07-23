package com.cps.views.activity;


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
import com.cps.databinding.DialogActivityParticipateBinding;
import com.cps.databinding.DialogChangePasswordBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.requests.SendEditPass;
import com.cps.models.requests.SendParticipate;
import com.cps.models.responses.ChildrenItem;
import com.cps.views.profile.ProfileViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class ActivityParticipateDialog extends DialogFragment {

    DialogActivityParticipateBinding binding;
    ActivityViewModel viewModel;
    ProgressDialog dialog;
    UserData user;
    List<ChildrenItem> items;
    SendParticipate participate;

    int activity_id;

    public ActivityParticipateDialog(int activity_id) {
        this.activity_id = activity_id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.dialog_activity_participate , container , false);
        binding.setLifecycleOwner(this);
        viewModel =  ViewModelProviders.of(requireActivity()).get(ActivityViewModel.class);
        user = new UserData(getContext());
        items = new ArrayList<>();
        binding.setUser(user);
        binding.setViewModel(viewModel);
        participate = new SendParticipate();

        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    dialog.show();
                    participate.setActivityId(activity_id);
                    participate.setChildren(items);
                    viewModel.activity_participate(new UserData(getContext()).getToken(), participate);
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
        viewModel.partLiveData.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(getActivity(), R.string.success, Toast.LENGTH_SHORT).show();
                    dismiss();
                }else if (integer == STATUS_CODE_ERROR_TOKEN){
                new GlobalFunction().userLogOut(getActivity());
            }else {
                    Log.d("Test", " "+ integer);
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
        for (int i = 0;i<user.getChildrenItems().size();i++){
            if (user.getChildrenItems().get(i).isSelected())
                items.add(user.getChildrenItems().get(i));
        }

        if (items.size() == 0) {
            check = false;
            Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();
        }

        return check;
    }
}
