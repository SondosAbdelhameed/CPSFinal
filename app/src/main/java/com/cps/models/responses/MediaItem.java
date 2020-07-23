package com.cps.models.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MediaItem implements Serializable {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("event_news_id")
	private String eventNewsId;

	@SerializedName("id")
	private int id;

	@SerializedName("media")
	private String media;

	@SerializedName("media_type_id")
	private String mediaTypeId;

	@SerializedName("status")
	private String status;

	protected MediaItem(Parcel in) {
		updatedAt = in.readString();
		createdAt = in.readString();
		eventNewsId = in.readString();
		id = in.readInt();
		media = in.readString();
		mediaTypeId = in.readString();
		status = in.readString();
	}
/*
	public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
		@Override
		public MediaItem createFromParcel(Parcel in) {
			return new MediaItem(in);
		}

		@Override
		public MediaItem[] newArray(int size) {
			return new MediaItem[size];
		}
	};*/

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

	public void setEventNewsId(String eventNewsId){
		this.eventNewsId = eventNewsId;
	}

	public String getEventNewsId(){
		return eventNewsId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMedia(String media){
		this.media = media;
	}

	public String getMedia(){
		return media;
	}

	public void setMediaTypeId(String mediaTypeId){
		this.mediaTypeId = mediaTypeId;
	}

	public String getMediaTypeId(){
		return mediaTypeId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"MediaItem{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' +
			",event_news_id = '" + eventNewsId + '\'' + 
			",id = '" + id + '\'' + 
			",media = '" + media + '\'' + 
			",media_type_id = '" + mediaTypeId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}


}