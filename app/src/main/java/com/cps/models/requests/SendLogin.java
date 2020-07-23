package com.cps.models.requests;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.cps.BR;
import com.google.gson.annotations.SerializedName;

public class SendLogin extends BaseObservable {

	@Bindable
	@SerializedName("password")
	private String password;

	@Bindable
	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
		notifyPropertyChanged(BR.password);
	}

	@Bindable
	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
		notifyPropertyChanged(BR.email);
	}

	@Bindable
	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"SendLogin{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}