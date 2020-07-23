package com.cps.views.admission;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP2Binding;
import com.cps.models.requests.SendAdmission;

public class AdmissionPage2 extends Fragment {

    FragmentAdmissionP2Binding binding;
    SendAdmission admission;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p2, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        binding.setAdmission(admission);
        return binding.getRoot();
    }

    public static AdmissionPage2 newInstance(SendAdmission admission) {

        AdmissionPage2 f = new AdmissionPage2();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);

        f.setArguments(b);

        return f;
    }

    public boolean isValidate() {

        boolean check = true;

        /** father **/
        if(admission.getStuFaGuaName() == null || admission.getStuFaGuaName().isEmpty()) {
            check = false;
            binding.etStuFatherName.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuFaGuaPhone1() == null || admission.getStuFaGuaPhone1().isEmpty()) {
            check = false;
            binding.etStuFatherPhone.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuFaGuaEmail() == null || admission.getStuFaGuaEmail().isEmpty()) {
            check = false;
            binding.etStuFatherEmail.setError(getString(R.string.error_empty_data));
        }else if (!Patterns.EMAIL_ADDRESS.matcher(admission.getStuFaGuaEmail()).matches()){
            check = false;
            binding.etStuFatherEmail.setError(getString(R.string.error_email_format));
        }
        if(admission.getStuFaGuaOccup() == null || admission.getStuFaGuaOccup().isEmpty()) {
            check = false;
            binding.etStuFatherOccupation.setError(getString(R.string.error_empty_data));
        }


        /** mother **/
        if(admission.getStuMotherName() == null || admission.getStuMotherName().isEmpty()) {
            check = false;
            binding.etStuMotherName.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuMotherPhone1() == null || admission.getStuMotherPhone1().isEmpty()) {
            check = false;
            binding.etStuMotherPhone.setError(getString(R.string.error_empty_data));
        }
        if(admission.getStuMotherEmail() != null ) {
            if(!admission.getStuMotherEmail().isEmpty()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(admission.getStuMotherEmail()).matches()) {
                    check = false;
                    binding.etStuMotherEmail.setError(getString(R.string.error_email_format));
                }
            }
        }
        if(admission.getStuMotherOccup() == null || admission.getStuMotherOccup().isEmpty()) {
            check = false;
            binding.etStuMotherOccupation.setError(getString(R.string.error_empty_data));
        }





        /**
         * if return false show the error message for each fragment
         * */
        return check;
    }
}
