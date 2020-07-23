package com.cps.views.profile;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.requests.SendEditPass;
import com.cps.models.responses.JsonResponse;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    public static void edit_pass(String token , SendEditPass editPass , MutableLiveData<Integer> liveData , MutableLiveData<Throwable> errorLiveData) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.edit_pass(token,editPass);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(response.body().getStatus().getCode());
                } else{
                    try {
                        Log.d("Test",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    liveData.setValue(response.code());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                errorLiveData.setValue(t);
            }
        });

    }
}
