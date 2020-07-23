package com.cps.views.events_news;

import android.app.Application;
import android.app.ProgressDialog;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.R;
import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.responses.EventsNewsItem;
import com.cps.models.responses.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventNewsFragmentRepository {

    public static void requestdata(int type , MutableLiveData<List<EventsNewsItem>> liveData, MutableLiveData<Throwable> errorLiveData) {

        // final MutableLiveData<List<EventsNewsItem>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.event_news(type);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response.isSuccessful() && response.body()!=null ) {
                    liveData.setValue(response.body().getData().getEventsNews());

                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  "+t);
                errorLiveData.setValue(t);
            }
        });


        // return mutableLiveData;
    }
}
