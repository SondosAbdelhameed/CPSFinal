package com.cps.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.cps.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessageService extends FirebaseMessagingService {

//    {
//        "to":"/topics/BeforeLogin",
//            "notification": {
//        "title": "Portugal vs. Denmark",
//                "body": "test test"
//    },
//        "data": {
//        "title": "Portugal vs. Denmark",
//                "body": "test test"
//    }
//    }
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null){

            showNotification(remoteMessage.getNotification().getTitle(),"from notification : ".concat(remoteMessage.getNotification().getBody()));
            //Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
           // Log.d("Test1", remoteMessage.getNotification().getImageUrl().toString());
        }else if (
                remoteMessage.getData().containsKey("title")
                        && remoteMessage.getData().containsKey("body")
        ){
            showNotification(remoteMessage.getData().get("title"),"from data : ".concat(remoteMessage.getData().get("body")));
            //Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
            //Log.d("Test2", remoteMessage.toString());
        }else{
           // Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public static final String fcmChannelID = "MyNotification";

    public void showNotification(String title , String message){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(fcmChannelID,"MyNotification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,fcmChannelID)
                .setContentIntent(PendingIntent.getActivity(this , 10 , new Intent(this, Notification.class) , PendingIntent.FLAG_UPDATE_CURRENT))
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manager =  NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.e("TAG_NOTIFICATION" , "token : "+s);
    }
}
