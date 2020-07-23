package com.cps.models.responses;

import com.google.gson.annotations.SerializedName;

public class GradesItem{

	@SerializedName("evaluation")
	private String evaluation;

	@SerializedName("course_name")
	private String courseName;

	@SerializedName("final_grade")
	private String finalGrade;

	@SerializedName("id")
	private int id;

	@SerializedName("student_code")
	private String studentCode;

	public void setEvaluation(String evaluation){
		this.evaluation = evaluation;
	}

	public String getEvaluation(){
		return evaluation;
	}

	public void setCourseName(String courseName){
		this.courseName = courseName;
	}

	public String getCourseName(){
		return courseName;
	}

	public void setFinalGrade(String finalGrade){
		this.finalGrade = finalGrade;
	}

	public String getFinalGrade(){
		return finalGrade;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStudentCode(String studentCode){
		this.studentCode = studentCode;
	}

	public String getStudentCode(){
		return studentCode;
	}

	@Override
 	public String toString(){
		return 
			"GradesItem{" + 
			"evaluation = '" + evaluation + '\'' + 
			",course_name = '" + courseName + '\'' + 
			",final_grade = '" + finalGrade + '\'' + 
			",id = '" + id + '\'' + 
			",student_code = '" + studentCode + '\'' + 
			"}";
		}
}