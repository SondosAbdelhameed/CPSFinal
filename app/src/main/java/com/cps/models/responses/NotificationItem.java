package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NotificationItem implements Serializable {

	@SerializedName("notification_type")
	private String notificationType;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("notification_title")
	private String notificationTitle;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("notification_content")
	private String notificationContent;

	@SerializedName("status")
	private String status;

	public void setNotificationType(String notificationType){
		this.notificationType = notificationType;
	}

	public String getNotificationType(){
		return notificationType;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNotificationTitle(String notificationTitle){
		this.notificationTitle = notificationTitle;
	}

	public String getNotificationTitle(){
		return notificationTitle;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNotificationContent(String notificationContent){
		this.notificationContent = notificationContent;
	}

	public String getNotificationContent(){
		return notificationContent;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String title(){
		if (notificationType.equals("1"))
			return "Event";
		else if (notificationType.equals("2"))
			return "News";
		else if (notificationType.equals("3"))
			return "Activity";
		else
			return "Message";
	}

	@Override
 	public String toString(){
		return 
			"NotificationItem{" + 
			"notification_type = '" + notificationType + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",notification_title = '" + notificationTitle + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",notification_content = '" + notificationContent + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}