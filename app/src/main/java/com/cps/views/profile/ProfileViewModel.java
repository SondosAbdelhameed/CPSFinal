package com.cps.views.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendEditPass;
import com.cps.models.responses.ChildrenItem;
import com.cps.views.MainActivity;
import com.cps.views.login.Login;
import com.cps.views.result.ExamResult;

public class ProfileViewModel extends ViewModel {

    ProfileRepository repository;

    final MutableLiveData<Integer> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public ProfileViewModel() {
        repository = new ProfileRepository();
    }

    void edit_pass(String token ,SendEditPass editPass ){
        ProfileRepository.edit_pass(token,editPass,liveData,errorLiveData);
    }

    public void goToLogin(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, Login.class));
    }

    public void goToResult(View v , ChildrenItem child){
        Context context = v.getContext();

        if(child != null) {
            Intent intent = new Intent(context, ExamResult.class);
            intent.putExtra("child", child);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void openDialog(View v , ProfileViewModel viewModel){
       // Context context = v.getContext();
        //Activity activity = (MainActivity) context;
        //EditPasswordDialog dialog = new EditPasswordDialog();
        //dialog.show(activity.frag);
    }
}