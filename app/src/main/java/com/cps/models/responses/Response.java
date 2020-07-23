package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("level")
	private Level level;

	public void setLevel(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return level;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"level = '" + level + '\'' + 
			"}";
		}
}