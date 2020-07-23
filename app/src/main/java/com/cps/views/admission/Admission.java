package com.cps.views.admission;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.cps.R;
import com.cps.databinding.ActivityAdmissionBinding;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;
import com.cps.models.responses.Data;
import com.cps.models.responses.JsonResponse;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;


public class Admission extends AppCompatActivity {

    ActivityAdmissionBinding binding;
    SendAdmission admission ;
    SendAdmissionMedia admissionMedia = new SendAdmissionMedia();
    Button next;
    AdmissionViewModel viewModel;
    ProgressDialog dialog;

    List<Fragment> fragmentList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admission);
        next = binding.btnNext;

        binding.vpAdmission.setAdapter(new MyPagerAdapter(this));
        viewModel = ViewModelProviders.of(this).get(AdmissionViewModel.class);

        // disable user swipe
        binding.vpAdmission.setUserInputEnabled(false); // here you can enable or disable swipe
        binding.tlVpDots.setViewPager2(binding.vpAdmission);
        binding.tlVpDots.setDotsClickable(false);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));

        binding.vpAdmission.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(position == 3)
                    next.setText("finish");
                else
                    next.setText(R.string.next);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = fragmentList.get(binding.vpAdmission.getCurrentItem());
                if (fragment instanceof AdmissionPage1) {
                    if (((AdmissionPage1) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage2) {
                    if (((AdmissionPage2) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage3) {
                    if (((AdmissionPage3) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage4) {
                    if (((AdmissionPage4) fragment).isValidate()) {
                        /**
                         *
                         * finish admission
                         * */
                        dialog.show();
                        viewModel.send_admission(admission);
                    }
                }

            }
        });

        viewModel.liveData.observe(Admission.this, new Observer<JsonResponse>() {
            @Override
            public void onChanged(JsonResponse response) {
                dialog.dismiss();
                if ( response.getStatus().getCode() == STATUS_CODE_SUCCESS){
                    Toast.makeText(Admission.this, R.string.success, Toast.LENGTH_SHORT).show();
                    admissionMedia.setAdmissionId(response.getData().getAdmissionId());
                    dialog.show();
                    admission.clear();
                    viewModel.send_admission_media(admissionMedia);

                }else {
                    Toast.makeText(Admission.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.liveDataMedia.observe(Admission.this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dialog.dismiss();
                if ( integer == STATUS_CODE_SUCCESS){
                    Toast.makeText(Admission.this, R.string.success, Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(Admission.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }

    private void initData() {
       admission = new SendAdmission(this);
       fragmentList = Arrays.asList(
                AdmissionPage1.newInstance(admission),
                AdmissionPage2.newInstance(admission),
                AdmissionPage3.newInstance(admission),
                AdmissionPage4.newInstance(admission , admissionMedia)
        );
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
//            switch (position) {
//
//                case 1: return AdmissionPage2.newInstance(admission);
//                case 2: return AdmissionPage3.newInstance(admission);
//                case 3: return AdmissionPage4.newInstance(admission);
//                default: return AdmissionPage1.newInstance(admission);
//            }
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}
