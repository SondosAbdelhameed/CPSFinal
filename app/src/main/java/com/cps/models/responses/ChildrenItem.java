package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChildrenItem implements Serializable {

	@SerializedName("national_id")
	private String nationalId;

	@SerializedName("name_ar")
	private String nameAr;

	@SerializedName("birth_date")
	private String birthDate;

	@SerializedName("level_id")
	private String levelId;

	@SerializedName("class_id")
	private String classId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("student_code")
	private String studentCode;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("student_status")
	private String studentStatus;

	@SerializedName("id")
	private int id;

	@SerializedName("name_en")
	private String nameEn;

	@SerializedName("status")
	private String status;

	@SerializedName("level")
	private Level level;

	@SerializedName("class_room")
	private ClassRoom classRoom;

	boolean isSelected;

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	public void setNationalId(String nationalId){
		this.nationalId = nationalId;
	}

	public String getNationalId(){
		return nationalId;
	}

	public void setNameAr(String nameAr){
		this.nameAr = nameAr;
	}

	public String getNameAr(){
		return nameAr;
	}

	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public void setLevelId(String levelId){
		this.levelId = levelId;
	}

	public String getLevelId(){
		return levelId;
	}

	public void setClassId(String classId){
		this.classId = classId;
	}

	public String getClassId(){
		return classId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setStudentCode(String studentCode){
		this.studentCode = studentCode;
	}

	public String getStudentCode(){
		return studentCode;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setStudentStatus(String studentStatus){
		this.studentStatus = studentStatus;
	}

	public String getStudentStatus(){
		return studentStatus;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNameEn(String nameEn){
		this.nameEn = nameEn;
	}

	public String getNameEn(){
		return nameEn;
	}

	public void setLevel(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return level;
	}

	public void setClassRoom(ClassRoom classRoom){
		this.classRoom = classRoom;
	}

	public ClassRoom getClassRoom(){
		return classRoom;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "ChildrenItem{" +
				"nationalId='" + nationalId + '\'' +
				", nameAr='" + nameAr + '\'' +
				", birthDate='" + birthDate + '\'' +
				", levelId='" + levelId + '\'' +
				", classId='" + classId + '\'' +
				", createdAt='" + createdAt + '\'' +
				", studentCode='" + studentCode + '\'' +
				", nationality='" + nationality + '\'' +
				", updatedAt='" + updatedAt + '\'' +
				", userId='" + userId + '\'' +
				", studentStatus='" + studentStatus + '\'' +
				", id=" + id +
				", nameEn='" + nameEn + '\'' +
				", status='" + status + '\'' +
				", level=" + level +
				", classRoom=" + classRoom +
				", isSelected=" + isSelected +
				'}';
	}
}