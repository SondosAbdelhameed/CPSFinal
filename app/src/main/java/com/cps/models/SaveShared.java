package com.cps.models;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import static android.content.Context.MODE_PRIVATE;

public class SaveShared {

    Boolean c = true;
    SharedPreferences preferences;
    Context activity;
    private String value;

    public SaveShared(Context activity , String key) {
        this.activity = activity;
        this.activity=activity;
        preferences=activity.getSharedPreferences(key, MODE_PRIVATE);
    }

    void saveObject(final HashMap<String,String>sharedData){
        for (Map.Entry<String, String> entry : sharedData.entrySet()) {
            final String key = entry.getKey();
            final String value = entry.getValue();
            preferences.edit().putString(key,value).apply();
        }
    }

    public void saveElement(String key, String value){
        preferences.edit().putString(key,value).apply();
    }

    public   void clear(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }

    public Boolean isLoged(){
        if (preferences.getAll().size()==0) {
            c = false;
        }
        return c;
    }

    public String getPreferences(String key){
        value= preferences.getString(key,"");
        return value;
    }
}
