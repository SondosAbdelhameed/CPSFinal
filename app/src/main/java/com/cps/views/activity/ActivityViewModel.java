package com.cps.views.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.R;
import com.cps.models.requests.SendParticipate;
import com.cps.models.responses.ActivitiesItem;
import com.cps.models.responses.ChildrenItem;
import com.cps.models.responses.JsonResponse;
import com.cps.views.ActivityDetails;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import static com.cps.helpers.Constant.SERVER_MEDIA_EVENT_NEWS;

public class ActivityViewModel extends ViewModel {

    ActivityRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();
    final MutableLiveData<Integer> partLiveData = new MutableLiveData<>();
    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public ActivityViewModel() {
        repository = new ActivityRepository();
    }

    void request_activity(String token){
        ActivityRepository.activity_data(token , liveData , errorLiveData);
    }

    void activity_participate(String token , SendParticipate participate){
        ActivityRepository.activity_participate(token ,participate, partLiveData , errorLiveData);
    }

    public void goToActivityDetails(View v , ActivitiesItem item){
        Context context = v.getContext();

        if(item != null) {
            Intent intent = new Intent(context, ActivityDetails.class);
            intent.putExtra("data", item);
            context.startActivity(intent);

        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @BindingAdapter("activityImage")
    public static void loadImage(RelativeLayout img , String image){
        Context context = img.getContext();
        if (image != null) {

            Picasso.get().load(SERVER_MEDIA_EVENT_NEWS + image).placeholder(R.drawable.anim_img_placeholder).into(new Target(){

                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    img.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                    Log.d("TAG", "FAILED");
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
                    Log.d("TAG", "Prepare Load");
                }
            });

        }else {
            image = "null";
        }
    }

    @BindingAdapter("values")
    public static void createCheckboxes(LinearLayout layout, List<ChildrenItem> items) {
        for (int i = 0; i < items.size(); i++) {
            CheckBox chk = new CheckBox(layout.getContext());
            chk.setText(items.get(i).getNameEn());
            chk.setChecked(items.get(i).isSelected());

            final int finalI = i;
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ChildrenItem item = items.get(finalI);

                        item.setSelected(isChecked);
                        //items.set(finalI,item);
                    //layout.invalidate();
                }
            });

            layout.addView(chk);
        }
    }

}
