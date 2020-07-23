package com.cps.helpers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.cps.R;
import com.cps.models.UserData;
import com.cps.views.MainActivity;
import com.cps.views.Splash;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GlobalFunction {

    public String date(String dateTime){
        String myFormat1 = "yyyy-MM-dd hh:mm:ss"; //In which you need put here
        SimpleDateFormat sdf1 = new SimpleDateFormat(myFormat1, Locale.US);

        String myFormat2 = "yyyy-MM-dd";
        SimpleDateFormat sdf2 = new SimpleDateFormat(myFormat2, Locale.US);
        String dateStr = "";
        try {
            Date date1 = sdf1.parse(dateTime);
            dateStr = sdf2.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("Test",e.toString());
        }
        if (dateStr != "")
        return dateStr;
        else
            return "123";
    }

    public  boolean isPermissionGranted(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED &&
                    activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permission","Permission is granted1");
                return true;
            } else {

                Log.v("Permission","Permission is revoked1");
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE , Manifest.permission.WRITE_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Permission","Permission is granted1");
            return true;
        }
    }

    public  void userLogOut(Activity activity) {
        Toast.makeText(activity, activity.getString(R.string.error_expired_token), Toast.LENGTH_LONG).show();
        Toast.makeText(activity, activity.getString(R.string.error_sign_again), Toast.LENGTH_LONG).show();
        new UserData(activity).logout();
        activity.finishAffinity();
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
