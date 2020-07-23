package com.cps.helpers;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cps.helpers.Constant.SERVER_BASE_URL;


/**
 * Created by Luffy on 12/15/2017.
 */

public class ApiClientLogin {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                // .writeTimeout(5, TimeUnit.SECONDS).addInterceptor(new BasicAuthInterceptor("ufelix","ufelix"))
                /* .addInterceptor(new Interceptor() {
                     @Override
                     public okhttp3.CategoryResponse intercept(Chain chain) throws IOException {
                         Request original = chain.request();
                         // Request customization: add request headers
                         Request.Builder requestBuilder = original.newBuilder().header("token", new User(ApplicationClass.getInstance().getApplicationContext()).getToken()); // <-- this is the important line

                         Request request = requestBuilder.build();
                         return chain.proceed(request);
                     }
                 })
                /* .addInterceptor(new Interceptor() {
                     @Override
                     public okhttp3.CategoryResponse intercept(Chain chain) throws IOException {
                         Request original = chain.request();

                         // Request customization: add request headers
                         Request.Builder requestBuilder = original.newBuilder()
                                 .header("Authorization", ApplicationClass.getCustomerToken()); // <-- this is the important line

                         Request request = requestBuilder.build();
                         return chain.proceed(request);
                     }
                 })*/
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();
        }
        return retrofit;
    }

    /*
    public static class BasicAuthInterceptor implements Interceptor {

        private String credentials;

        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
        }

        @Override
        public okhttp3.CategoryResponse intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
            return chain.proceed(authenticatedRequest);
        }

    }*/

}
