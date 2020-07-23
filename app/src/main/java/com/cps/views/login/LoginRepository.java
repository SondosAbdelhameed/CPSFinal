package com.cps.views.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.requests.SendLogin;
import com.cps.models.responses.JsonResponse;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    public static void login(SendLogin login , MutableLiveData<JsonResponse> liveData , MutableLiveData<Throwable> errorLiveData) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.login(login);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body()!=null ) {
                    liveData.setValue(response.body());
                }else if(response.errorBody() != null) {
                    try {
                        JsonResponse error = new Gson().fromJson(response.errorBody().string(), JsonResponse.class);
                        liveData.setValue(error);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  "+t);
                errorLiveData.setValue(t);
            }
        });

    }
}
