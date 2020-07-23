package com.cps.views.admission;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP3Binding;
import com.cps.models.requests.SendAdmission;

public class AdmissionPage3 extends Fragment {

    FragmentAdmissionP3Binding binding;
    SendAdmission admission;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p3, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        binding.setAdmission(admission);
        return binding.getRoot();
    }

    public static AdmissionPage3 newInstance(SendAdmission admission) {

        AdmissionPage3 f = new AdmissionPage3();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);

        f.setArguments(b);

        return f;
    }

    public boolean isValidate() {

        boolean check = true;
        if(admission.getStuEmergName() == null || admission.getStuEmergName().isEmpty()) {
            check = false;
            binding.etStuEmergencyName.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuEmergRelation() == null || admission.getStuEmergRelation().isEmpty()) {
            check = false;
            binding.etStuEmergencyRelation.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuEmergPhone() == null || admission.getStuEmergPhone().isEmpty()) {
            check = false;
            binding.etStuEmergencyPhone.setError(getString(R.string.error_empty_data));
        }
        if (!binding.cbDeclaration.isChecked()){
            check = false;
            binding.tvDeclaration.setError("You must check the Declaration");
        }


        /**
         * if return false show the error message for each fragment
         * */
        return check;
    }
}
