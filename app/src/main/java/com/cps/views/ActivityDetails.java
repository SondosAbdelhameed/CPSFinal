package com.cps.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.cps.R;
import com.cps.databinding.ActivityActivityDetailsBinding;
import com.cps.models.responses.ActivitiesItem;
import com.cps.views.activity.ActivityParticipateDialog;

public class ActivityDetails extends AppCompatActivity {

    ActivityActivityDetailsBinding binding;
    ActivitiesItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_activity_details);

        item = (ActivitiesItem) getIntent().getSerializableExtra("data");
        if(item != null) {
            binding.setActivity(item);

        }else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }

        binding.btnParticipate.setOnClickListener(v -> {
            ActivityParticipateDialog dialog = new ActivityParticipateDialog(item.getId());
            dialog.show(getSupportFragmentManager() , ActivityParticipateDialog.class.getSimpleName());
        });
    }
}
