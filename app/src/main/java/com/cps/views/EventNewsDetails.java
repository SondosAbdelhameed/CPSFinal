package com.cps.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.cps.R;
import com.cps.adapters.ViewPagerAdapter;
import com.cps.databinding.ActivityEventNewsDetailsBinding;
import com.cps.models.responses.EventsNewsItem;
import com.cps.views.activity.ActivityParticipateDialog;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class EventNewsDetails extends AppCompatActivity  {

    ActivityEventNewsDetailsBinding binding;
    ViewPagerAdapter adapter;
    ViewPager viewPager;
    SpringDotsIndicator tab;
    EventsNewsItem item;

    Timer timer;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_event_news_details);
        viewPager = binding.vpImage;
        tab = binding.tlVpDots;


        item = (EventsNewsItem) getIntent().getSerializableExtra("data");
        if(item != null) {
            binding.setNews(item);

            adapter = new ViewPagerAdapter(this, item.getMedia());
            viewPager.setAdapter(adapter);
            tab.setViewPager(viewPager);
            pageSwitcher(3);

        }else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


    }



    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay// in milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {
        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {
                    viewPager.setCurrentItem(page);
                    if (page < item.getMedia().size() ) { // In my case the number of pages are 5
                        //timer.cancel();
                        page ++;
                    } else {
                        page = 0;
                    }
                }
            });

        }
    }


}
