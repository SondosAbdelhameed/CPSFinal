package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClassRoom implements Serializable {

	@SerializedName("address")
	private Object address;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("class_name")
	private String className;

	@SerializedName("class_code")
	private String classCode;

	@SerializedName("status")
	private String status;

	public void setAddress(Object address){
		this.address = address;
	}

	public Object getAddress(){
		return address;
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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public String getClassName(){
		return className;
	}

	public void setClassCode(String classCode){
		this.classCode = classCode;
	}

	public String getClassCode(){
		return classCode;
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
			"ClassRoom{" + 
			"address = '" + address + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",class_name = '" + className + '\'' + 
			",class_code = '" + classCode + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}