package com.cps.views.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendLogin;
import com.cps.models.responses.JsonResponse;
import com.cps.views.forget.ForgetPassword;

public class LoginViewModel extends ViewModel {

    LoginRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    void login(SendLogin login ){
        LoginRepository.login(login,liveData,errorLiveData);
    }

    public void goToForget(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, ForgetPassword.class));
    }
}
