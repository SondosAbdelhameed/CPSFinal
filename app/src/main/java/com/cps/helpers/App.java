package com.cps.helpers;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cps.models.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        FirebaseMessaging.getInstance().subscribeToTopic("BeforeLogin")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "BeforeLogin  :  msg_subscribed";
                        if (!task.isSuccessful()) {
                            msg = "BeforeLogin  :  msg_subscribe_failed";
                        }
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                    }
                });

        if(new UserData(getAppContext()).isLoged()){
            FirebaseMessaging.getInstance().subscribeToTopic("AfterLogin")
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = "AfterLogin  :  msg_subscribed";
                            if (!task.isSuccessful()) {
                                msg = "AfterLogin  :  msg_subscribe_failed";
                            }
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        }
                    });

            FirebaseMessaging.getInstance().subscribeToTopic("user"+new UserData(getAppContext()).getCode())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = "Message  :  "+ new UserData(getApplicationContext()).getCode();
                            if (!task.isSuccessful()) {
                                msg = "Massage  :  msg_subscribe_failed";
                            }
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    public static Context getAppContext() {
        return App.context;
    }
}
