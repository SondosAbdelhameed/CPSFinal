package com.cps.views.notification;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.R;
import com.cps.models.responses.ActivitiesItem;
import com.cps.models.responses.EventsNewsItem;
import com.cps.models.responses.JsonResponse;
import com.cps.models.responses.NotificationItem;
import com.cps.views.ActivityDetails;
import com.cps.views.EventNewsDetails;
import com.cps.views.message.Message;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class NotificationViewModel extends ViewModel {

    NotificationRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();
    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public NotificationViewModel() {
        repository = new NotificationRepository();
    }

    void notification_before(){
        NotificationRepository.notification_before(liveData , errorLiveData);
    }

    void notification_after(String token){
        NotificationRepository.notification_after(token , liveData , errorLiveData);
    }

    public void goToDetails(View v , NotificationItem item){
        Context context = v.getContext();

        if(item != null) {
            Intent intent = null;
            if (item.getNotificationType().equals("1") || item.getNotificationType().equals("2")) {
                intent = new Intent(context, EventNewsDetails.class);
                intent.putExtra("data", new Gson().fromJson(item.getNotificationContent(), EventsNewsItem.class));
            }
            else if(item.getNotificationType().equals("3")) {
                intent = new Intent(context, ActivityDetails.class);
                intent.putExtra("data", new Gson().fromJson(item.getNotificationContent(), ActivitiesItem.class));
            }
            else
                intent = new Intent(context, Message.class);

            context.startActivity(intent);

        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }


    @BindingAdapter("notificationImage")
    public static void loadImage(AppCompatImageView img , String type){
        Context context = img.getContext();


        if (type.equals("1"))
            img.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_event));
        else if (type.equals("2"))
            img.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_news));
        else if (type.equals("3"))
            img.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_activity));
        else
            img.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_message));

    }
}
