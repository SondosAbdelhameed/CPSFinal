package com.cps.models;


import android.content.Context;
import android.util.Log;

import com.cps.models.responses.ChildrenItem;
import com.cps.models.responses.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserData {

    String key= UserData.class.getName();
    SaveShared saveShared;

    List<ChildrenItem> childrenItems;

    public UserData(Context context) {
        saveShared =new SaveShared(context,key);
    }

    public UserData(Context context , User user ) {
        HashMap<String,String>mapUser=new HashMap<>();
        mapUser.put("id",user.getId());
        mapUser.put("token",user.getToken());
        mapUser.put("name",user.getName());
        mapUser.put("email",user.getEmail());
        mapUser.put("phone",user.getPhone());
        mapUser.put("code",user.getUserCode());
        saveShared =new SaveShared(context,key);
        saveShared.saveObject(mapUser);
    }

    public String getId() {
        return saveShared.getPreferences("id");
    }

    public void setId(String id) {
        saveShared.saveElement("id",id);
    }

    public String getToken() {
        return "bearer "+saveShared.getPreferences("token");
    }

    public void setToken(String token) {
        saveShared.saveElement("token",token);
    }

    public String getName() {
        return saveShared.getPreferences("name");
    }

    public void setName(String name) {
        saveShared.saveElement("name",name);
    }

    public String getEmail() {
      return   saveShared.getPreferences("email");
    }

    public void setEmail(String email) {
        saveShared.saveElement("email",email);
    }

    public String getPhone() {
      return saveShared.getPreferences("phone");
    }

    public void setPhone(String phone) {
        saveShared.saveElement("phone",phone);
    }

    public String getCode() {
      return  saveShared.getPreferences("code");
    }

    public void setCode(String code) {
        saveShared.saveElement("code",code);
    }

    public void setChildren(List<ChildrenItem> childrenItems) {
        Gson gson = new Gson();
        saveShared.saveElement("children",gson.toJson(childrenItems));
    }

    public List<ChildrenItem> getChildren() {
        List<ChildrenItem> childrenItems = new ArrayList<>();
        Gson gson = new Gson();
        Type type = new TypeToken<List<ChildrenItem>>() {  }.getType();
        childrenItems.addAll(gson.fromJson(saveShared.getPreferences("children"), type));
        return childrenItems;
    }

    public List<ChildrenItem> getChildrenItems() {
        if(childrenItems == null)
            childrenItems = getChildren();
        return childrenItems;
    }

    public boolean isLoged() {
        return saveShared.isLoged();
    }

    public void logout(){saveShared.clear();}

}

