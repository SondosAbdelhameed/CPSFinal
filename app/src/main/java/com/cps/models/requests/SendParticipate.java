package com.cps.models.requests;

import com.cps.models.responses.ChildrenItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendParticipate {

	@SerializedName("children")
	private List<ChildrenItem> children;

	@SerializedName("activity_id")
	private int activityId;

	public void setChildren(List<ChildrenItem> children){
		this.children = children;
	}

	public List<ChildrenItem> getChildren(){
		return children;
	}

	public void setActivityId(int activityId){
		this.activityId = activityId;
	}

	public int getActivityId(){
		return activityId;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"children = '" + children + '\'' + 
			",activity_id = '" + activityId + '\'' + 
			"}";
		}
}