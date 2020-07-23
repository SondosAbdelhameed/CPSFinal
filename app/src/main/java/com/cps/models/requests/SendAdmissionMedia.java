package com.cps.models.requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SendAdmissionMedia implements Serializable {

	@SerializedName("stu_fa_qual_photo")
	private String stuFaQualPhoto;

	@SerializedName("stu_photo")
	private String stuPhoto;

	@SerializedName("stu_mo_qual_photo")
	private String stuMoQualPhoto;

	@SerializedName("stu_birth_photo")
	private String stuBirthPhoto;

	@SerializedName("admission_id")
	private int admissionId;

	@SerializedName("stu_mo_id_photo")
	private String stuMoIdPhoto;

	@SerializedName("stu_fa_id_photo")
	private String stuFaIdPhoto;

	public void setStuFaQualPhoto(String stuFaQualPhoto){
		this.stuFaQualPhoto = stuFaQualPhoto;
	}

	public String getStuFaQualPhoto(){
		return stuFaQualPhoto;
	}

	public void setStuPhoto(String stuPhoto){
		this.stuPhoto = stuPhoto;
	}

	public String getStuPhoto(){
		return stuPhoto;
	}

	public void setStuMoQualPhoto(String stuMoQualPhoto){
		this.stuMoQualPhoto = stuMoQualPhoto;
	}

	public String getStuMoQualPhoto(){
		return stuMoQualPhoto;
	}

	public void setStuBirthPhoto(String stuBirthPhoto){
		this.stuBirthPhoto = stuBirthPhoto;
	}

	public String getStuBirthPhoto(){
		return stuBirthPhoto;
	}

	public void setAdmissionId(int admissionId){
		this.admissionId = admissionId;
	}

	public int getAdmissionId(){
		return admissionId;
	}

	public void setStuMoIdPhoto(String stuMoIdPhoto){
		this.stuMoIdPhoto = stuMoIdPhoto;
	}

	public String getStuMoIdPhoto(){
		return stuMoIdPhoto;
	}

	public void setStuFaIdPhoto(String stuFaIdPhoto){
		this.stuFaIdPhoto = stuFaIdPhoto;
	}

	public String getStuFaIdPhoto(){
		return stuFaIdPhoto;
	}

	@Override
 	public String toString(){
		return 
			"SendAdmissionMedia{" + 

			",stu_photo = '" + stuPhoto + '\'' +
			",stu_birth_photo = '" + stuBirthPhoto + '\'' + 
			",admission_id = '" + admissionId + '\'' + 
			",stu_mo_id_photo = '" + stuMoIdPhoto + '\'' + 
			",stu_fa_id_photo = '" + stuFaIdPhoto + '\'' +
			"stu_fa_qual_photo = '" + stuFaQualPhoto + '\'' +
			",stu_mo_qual_photo = '" + stuMoQualPhoto + '\'' +
			"}";
		}
}