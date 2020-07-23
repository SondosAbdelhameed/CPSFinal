package com.cps.views.contact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendContact;

public class ContactUsViewModel extends ViewModel {

    ContactUsRepository repository;

    final MutableLiveData<Integer> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public ContactUsViewModel() {
        repository = new ContactUsRepository();
    }

    void send_contact(SendContact contact ){
        ContactUsRepository.requestdata(contact,liveData,errorLiveData);
    }
}
