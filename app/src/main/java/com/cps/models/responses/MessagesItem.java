package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

public class MessagesItem{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("message")
	private String message;

	@SerializedName("message_owner")
	private String messageOwner;

	@SerializedName("message_room_id")
	private String messageRoomId;

	@SerializedName("status")
	private String status;

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setMessageOwner(String messageOwner){
		this.messageOwner = messageOwner;
	}

	public String getMessageOwner(){
		return messageOwner;
	}

	public void setMessageRoomId(String messageRoomId){
		this.messageRoomId = messageRoomId;
	}

	public String getMessageRoomId(){
		return messageRoomId;
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
			"MessagesItem{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",message = '" + message + '\'' + 
			",message_owner = '" + messageOwner + '\'' + 
			",message_room_id = '" + messageRoomId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}