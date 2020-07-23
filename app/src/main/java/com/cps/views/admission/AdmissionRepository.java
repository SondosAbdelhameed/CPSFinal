package com.cps.views.admission;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;
import com.cps.models.responses.Data;
import com.cps.models.responses.JsonResponse;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdmissionRepository {

    public static void requestadmissiondata(SendAdmission admission , MutableLiveData<JsonResponse> liveData , MutableLiveData<Throwable> errorLiveData) {

       // final MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.admission_data(admission);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(response.body());
                } else if(response.errorBody() != null){
                    try {
                        JsonResponse error = new Gson().fromJson(response.errorBody().string() , JsonResponse.class);
                        liveData.setValue(error);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                   // liveData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                errorLiveData.setValue(t);
            }
        });


        //return mutableLiveData;
    }

    public static void requestadmissionmedia(SendAdmissionMedia admission , MutableLiveData<Integer> liveData , MutableLiveData<Throwable> errorLiveData) {

        final MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.admission_media(admission);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    //mutableLiveData.setValue(response.body().getData().getEventsNews());
                    liveData.setValue(response.body().getStatus().getCode());
                } else {

                    liveData.setValue(response.code());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  " + t);
                errorLiveData.setValue(t);
            }
        });


        //return mutableLiveData;
    }
}
