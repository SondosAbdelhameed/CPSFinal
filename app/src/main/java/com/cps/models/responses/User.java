package com.cps.models.responses;

import android.content.Context;

import com.cps.models.SaveShared;
import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("id")
	String id;

	@SerializedName("phone1")
	private String phone;

	@SerializedName("token")
	private String token;

	@SerializedName("user_code")
	private String userCode;

	@SerializedName("email")
	private String email;

	@SerializedName("name_en")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setUserCode(String userCode){
		this.userCode = userCode;
	}

	public String getUserCode(){
		return userCode;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"name_ar = '" + name + '\'' +
			",phone1 = '" + phone + '\'' +
			",token = '" + token + '\'' + 
			",user_code = '" + userCode + '\'' + 
			",email = '" + email + '\'' +
			",name_en = '" + name + '\'' +
			"}";
		}
}