package com.cps.views.forget;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendLogin;

public class ForgetPasswordViewModel extends ViewModel {

    ForgetPasswordRepository repository;

    final MutableLiveData<Integer> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    void forget_password(SendLogin login ){
        ForgetPasswordRepository.forget_password(login,liveData,errorLiveData);
    }

}
