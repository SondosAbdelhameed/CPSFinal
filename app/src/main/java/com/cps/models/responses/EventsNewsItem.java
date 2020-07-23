package com.cps.models.responses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.cps.R;
import com.cps.helpers.App;
import com.cps.helpers.GlobalFunction;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static com.cps.helpers.Constant.SERVER_MEDIA_EVENT_NEWS;

public class EventsNewsItem implements Serializable {
	GlobalFunction globalFunction;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("e_n_type")
	private String eNType;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private String content;

	@SerializedName("status")
	private String status;

	public EventsNewsItem(String updatedAt, String eNType, String createdAt, int id, List<MediaItem> media, String title, String content, String status) {
		this.updatedAt = updatedAt;
		this.eNType = eNType;
		this.createdAt = createdAt;
		this.id = id;
		this.media = media;
		this.title = title;
		this.content = content;
		this.status = status;
		//globalFunction = new GlobalFunction();
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setENType(String eNType){
		this.eNType = eNType;
	}

	public String getENType(){
		return eNType;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return new GlobalFunction().date(createdAt);
		/*Date date = new Date(createdAt);
		DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(App.getAppContext());
		 dateFormat.format(date);
		return createdAt;*/
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@BindingAdapter("eventNewsImage")
	public static void loadImage(RelativeLayout img , MediaItem mediaItem){
		String image;
		Context context = img.getContext();
		if (mediaItem != null) {
			image = mediaItem.getMedia();

			Picasso.get().load(SERVER_MEDIA_EVENT_NEWS + mediaItem.getMedia()).placeholder(R.drawable.anim_img_placeholder).into(new Target(){

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
			"EventsNewsItem{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",e_n_type = '" + eNType + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",media = '" + media + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

}