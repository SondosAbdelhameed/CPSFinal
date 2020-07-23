package com.cps.views.admission;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP1Binding;
import com.cps.helpers.App;
import com.cps.models.requests.SendAdmission;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AdmissionPage1 extends Fragment {

    FragmentAdmissionP1Binding binding;
    SendAdmission admission;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p1, container, false);

            admission = (SendAdmission) getArguments().getSerializable("admission");
            binding.setAdmission(admission);
            binding.tvBirthDate.setOnClickListener(v -> {
                /*DatePickerDialog.OnDateSetListener date = */
                calendar();
                // openCalendar(date);
            });
            //if (savedInstanceState == null)
            //savedInstanceState.putSerializable("admission",admission);

        return binding.getRoot();
    }

  /*  @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null)
        outState.putSerializable("admission",admission);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null)
        savedInstanceState.putSerializable("admission",admission);
    }*/

    public static AdmissionPage1 newInstance(SendAdmission admission) {

        AdmissionPage1 f = new AdmissionPage1();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);

        f.setArguments(b);

        return f;
    }

    public boolean isValidate() {

        boolean check = true;

        if(admission.getStuNationalId() == null || admission.getStuNationalId().isEmpty()) {
            check = false;
            binding.etStuNationalId.setError(getString(R.string.error_empty_data));
        }
        if (admission.getStuFname() == null || admission.getStuFname().isEmpty()){
            check = false;
            binding.etStuFullName.setError(getString(R.string.error_empty_data));
        }
        if (admission.getStuAddress() == null || admission.getStuAddress().isEmpty()){
            check = false;
            binding.etStuAddress.setError(getString(R.string.error_empty_data));
        }
        if (admission.getStuBirthDate() == null || admission.getStuBirthDate().isEmpty()){
            check = false;
            binding.tvBirthDate.setError(getString(R.string.error_empty_data));
        }


        if (admission.getBroSisName() != null){
            if (admission.getBroSisGrade() == null ) {
                if (admission.getBroSisGrade().isEmpty())
                    admission.setBroSisGrade((new App().getAppContext().getResources().getStringArray(R.array.apply_for))[0]);
            }
        }else
            admission.setBroSisGrade("");
        /**
         * if return false show the error message for each fragment
         * */
        return check;
    }

   void calendar(){
        DatePickerDialog datepicker = new DatePickerDialog(getContext(), R.style.DatePickerDialog,
                new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                binding.tvBirthDate.setText(sdf.format(myCalendar.getTime()));
            }
        }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));

        datepicker.show();
    }

}
