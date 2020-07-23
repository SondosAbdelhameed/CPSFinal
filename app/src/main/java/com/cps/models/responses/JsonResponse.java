package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

public class JsonResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private Status status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"JsonResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}