package com.cps.views.message;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.JsonResponse;

public class MessageViewModel extends ViewModel {

    MessageRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();
    final MutableLiveData<Integer> sendLiveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public MessageViewModel() {
        repository = new MessageRepository();
    }

    void get_message(String token){
        MessageRepository.get_message(token , liveData , errorLiveData);
    }

    void send_message(String token , String message){
        MessageRepository.send_message(token , message , sendLiveData , errorLiveData);
    }
}
