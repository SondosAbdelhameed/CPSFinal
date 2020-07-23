package com.cps.views.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cps.R;
import com.cps.adapters.GradeAdapter;
import com.cps.databinding.ActivityExamResultBinding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.UserData;
import com.cps.models.responses.ChildrenItem;
import com.cps.models.responses.JsonResponse;
import com.google.android.material.snackbar.Snackbar;

import static com.cps.helpers.Constant.STATUS_CODE_ERROR_TOKEN;
import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class ExamResult extends AppCompatActivity {

    ActivityExamResultBinding binding;
    ProgressDialog dialog;
    ExamResultViewModel viewModel;
    GradeAdapter adapter;
    String stu_code;
    ChildrenItem child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_exam_result);
        viewModel = ViewModelProviders.of(this).get(ExamResultViewModel.class);
        RecyclerView recyclerView = binding.rcvResult;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        if(getIntent().hasExtra("child"))
            child = (ChildrenItem) getIntent().getSerializableExtra("child");
        else
            child = new UserData(this).getChildren().get(0);

        binding.setStuName(child.getNameEn());
        stu_code = child.getStudentCode();

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();

        viewModel.get_grade(new UserData(this).getToken(), stu_code);
        viewModel.liveData.observe(ExamResult.this, new Observer<JsonResponse>() {
            @Override
            public void onChanged(JsonResponse response) {
                dialog.dismiss();
                if (response.getStatus().getCode() == STATUS_CODE_SUCCESS){
                    Toast.makeText(ExamResult.this, R.string.success, Toast.LENGTH_SHORT).show();

                    adapter = new GradeAdapter(response.getData().getGrades());
                    recyclerView.setAdapter(adapter);

                }else if (response.getStatus().getCode() == STATUS_CODE_ERROR_TOKEN){
                    new GlobalFunction().userLogOut(ExamResult.this);
                }else {
                    Toast.makeText(ExamResult.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.errorLiveData.observe(this, throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            binding.incErrorInternet.setVisibility(View.VISIBLE);
            binding.rcvResult.setVisibility(View.GONE);
        });

    }
}
