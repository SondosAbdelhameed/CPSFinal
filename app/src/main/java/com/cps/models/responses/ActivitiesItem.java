package com.cps.models.responses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;

import com.cps.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.Serializable;

import static com.cps.helpers.Constant.SERVER_MEDIA_ACTIVITY;

public class ActivitiesItem implements Serializable {

	@SerializedName("date")
	private String date;

	@SerializedName("image")
	private String image;

	@SerializedName("cost")
	private String cost;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("details")
	private String details;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private String status;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCost(String cost){
		this.cost = cost;
	}

	public String getCost(){
		return cost;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDetails(String details){
		this.details = details;
	}

	public String getDetails(){
		return details;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@BindingAdapter("activityImage")
	public static void loadImage(RelativeLayout img , String image){

		Context context = img.getContext();
		if (image != null) {

			Picasso.get().load(SERVER_MEDIA_ACTIVITY + image).placeholder(R.drawable.anim_img_placeholder).into(new Target(){

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

	@Override
 	public String toString(){
		return 
			"ActivitiesItem{" + 
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",cost = '" + cost + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",details = '" + details + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}