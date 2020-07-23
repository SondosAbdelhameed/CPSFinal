package com.cps.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.cps.R;
import com.cps.models.responses.MediaItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import static com.cps.helpers.Constant.SERVER_MEDIA_EVENT_NEWS;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    List<MediaItem> items;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, List<MediaItem> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        RelativeLayout img = new RelativeLayout(context);

       // Picasso.get().load(SERVER_MEDIA_EVENT_NEWS + items.get(position).getMedia()).into(imageView);

        Picasso.get().load(SERVER_MEDIA_EVENT_NEWS + items.get(position).getMedia()).placeholder(R.drawable.anim_img_placeholder).into(new Target(){

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

        container.addView(img);

        return img;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
