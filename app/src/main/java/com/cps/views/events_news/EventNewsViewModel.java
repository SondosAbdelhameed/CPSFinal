package com.cps.views.events_news;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.EventsNewsItem;
import com.cps.views.EventNewsDetails;

import java.util.List;

public class EventNewsViewModel extends ViewModel {

    EventNewsFragmentRepository repository;

    final MutableLiveData<List<EventsNewsItem>> liveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public EventNewsViewModel() {
        repository = new EventNewsFragmentRepository();
    }

    void request_news(/*data to api*/){
        EventNewsFragmentRepository.requestdata(2 , liveData , errorLiveData);
    }

    void request_event(/*data to api*/){
        EventNewsFragmentRepository.requestdata(1,liveData , errorLiveData);
    }


    public void goToEventDetails(View v , EventsNewsItem item){
        Context context = v.getContext();
        if(item != null) {
            Intent intent = new Intent(context, EventNewsDetails.class);
            intent.putExtra("data", item);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}