package com.cps.models.requests;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.cps.BR;
import com.cps.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.annotations.SerializedName;

public class SendContact extends BaseObservable {

	@Bindable
	@SerializedName("phone")
	private String phone;

	@Bindable
	@SerializedName("subject")
	private String subject;

	@Bindable
	@SerializedName("name")
	private String name;

	@Bindable
	@SerializedName("message")
	private String message;

	@Bindable
	@SerializedName("email")
	private String email;

	public void setPhone(String phone){
		this.phone = phone;
		notifyPropertyChanged(com.cps.BR.phone);
	}

	@Bindable
	public String getPhone(){
		return phone;
	}

	public void setSubject(String subject){
		this.subject = subject;
		notifyPropertyChanged(com.cps.BR.subject);
	}

	@Bindable
	public String getSubject(){
		return subject;
	}

	public void setName(String name){
		this.name = name;
        notifyPropertyChanged(com.cps.BR.name);
	}

	@Bindable
	public String getName(){
		return name;
	}

	public void setMessage(String message){
		this.message = message;
		notifyPropertyChanged(com.cps.BR.message);
	}

	@Bindable
	public String getMessage(){
		return message;
	}

	public void setEmail(String email){
		this.email = email;
		notifyPropertyChanged(com.cps.BR.email);
	}

	@Bindable
	public String getEmail(){
		return email;
	}

	@BindingAdapter("errorNull")
	public static void errorNull(TextInputLayout editText, String text) {
		if (TextUtils.isEmpty(text)) {
			editText.setError(null);
			return;
		}
		if(text.length()>0)
			editText.setError(null);
	}

	@Override
 	public String toString(){
		return 
			"SendContact{" + 
			"phone = '" + phone + '\'' + 
			",subject = '" + subject + '\'' + 
			",name = '" + name + '\'' + 
			",message = '" + message + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}