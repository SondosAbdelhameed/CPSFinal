package com.cps.views.result;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.JsonResponse;

public class ExamResultViewModel extends ViewModel {
    ExamResultRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    void get_grade(String token , String code){
        ExamResultRepository.get_grades(token,code,liveData,errorLiveData);
    }

}
