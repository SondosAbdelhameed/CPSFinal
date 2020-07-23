package com.cps.models.requests;

import android.content.Context;

import com.cps.R;
import com.cps.helpers.App;
import com.cps.models.SaveShared;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SendAdmission implements Serializable {

	SaveShared saveShared;
	String key= SendAdmission.class.getName();


	@SerializedName("stu_fa_qual_photo")
	private String stuFaQualPhoto;

	@SerializedName("stu_parents_status")
	private String stuParentsStatus;

	@SerializedName("stu_faname")
	private String stuFaname;

	@SerializedName("stu_level")
	private String stuLevel;

	@SerializedName("stu_mother_email")
	private String stuMotherEmail;

	@SerializedName("stu_fa_gua_phone1")
	private String stuFaGuaPhone1;

	@SerializedName("stu_bus")
	private String stuBus;

	@SerializedName("stu_fa_gua_phone2")
	private String stuFaGuaPhone2;

	@SerializedName("stu_fname")
	private String stuFname;

	@SerializedName("stu_guardian")
	private String stuGuardian;

	@SerializedName("stu_mother_occup")
	private String stuMotherOccup;

	@SerializedName("stu_medical_info")
	private String stuMedicalInfo;

	@SerializedName("stu_photo")
	private String stuPhoto;

	@SerializedName("stu_nationality")
	private String stuNationality;

	@SerializedName("stu_address")
	private String stuAddress;

	@SerializedName("stu_emerg_name")
	private String stuEmergName;

	@SerializedName("stu_national_id")
	private String stuNationalId;

	@SerializedName("bro_sis_name")
	private String broSisName;

	@SerializedName("stu_fa_gua_email")
	private String stuFaGuaEmail;

	@SerializedName("stu_religion")
	private String stuReligion;

	@SerializedName("stu_birth_date")
	private String stuBirthDate;

	@SerializedName("stu_emerg_relation")
	private String stuEmergRelation;

	@SerializedName("stu_mother_name")
	private String stuMotherName;

	@SerializedName("bro_sis_grade")
	private String broSisGrade;

	@SerializedName("stu_emerg_phone")
	private String stuEmergPhone;

	@SerializedName("stu_birth_photo")
	private String stuBirthPhoto;

	@SerializedName("stu_lname")
	private String stuLname;

	@SerializedName("stu_fa_gua_name")
	private String stuFaGuaName;

	@SerializedName("stu_fa_gua_occup")
	private String stuFaGuaOccup;

	@SerializedName("stu_transferred_sch")
	private String stuTransferredSch;

	@SerializedName("stu_mother_phone1")
	private String stuMotherPhone1;

	@SerializedName("stu_gender")
	private String stuGender;

	@SerializedName("stu_mother_phone2")
	private String stuMotherPhone2;

	@SerializedName("stu_mo_qual_photo")
	private String stuMoQualPhoto;

	@SerializedName("stu_sec_lang")
	private String stuSecLang;

	@SerializedName("stu_mo_id_photo")
	private String stuMoIdPhoto;

	@SerializedName("stu_fa_id_photo")
	private String stuFaIdPhoto;

	public SendAdmission(Context context) {
		saveShared =new SaveShared(context,key);

		stuGender = (context.getResources().getStringArray(R.array.gender))[0];
		stuReligion = (context.getResources().getStringArray(R.array.religion))[0];
		stuParentsStatus = (context.getResources().getStringArray(R.array.marital_status))[0];
		stuGuardian = (context.getResources().getStringArray(R.array.guardian))[0];
		stuLevel = (context.getResources().getStringArray(R.array.apply_for))[0];
		stuSecLang = (context.getResources().getStringArray(R.array.second_language))[0];
		stuNationality = (context.getResources().getStringArray(R.array.nationality))[0];
		stuBus = (context.getResources().getStringArray(R.array.bus))[0];
	}

	public void setStuFaQualPhoto(String stuFaQualPhoto){
		this.stuFaQualPhoto = stuFaQualPhoto;
		saveShared.saveElement("stu_fa_qual_photo",stuNationalId);
	}

	public String getStuFaQualPhoto(){
		return saveShared.getPreferences("stu_fa_qual_photo");
	}

	public void setStuParentsStatus(String stuParentsStatus){
		this.stuParentsStatus = stuParentsStatus;
		saveShared.saveElement("stu_parents_status",stuNationalId);
	}

	public String getStuParentsStatus(){
		return saveShared.getPreferences("stu_parents_status");
	}

	public void setStuLevel(String stuLevel){
		this.stuLevel = stuLevel;
		saveShared.saveElement("stu_level",stuNationalId);
	}

	public String getStuLevel(){
		return saveShared.getPreferences("stu_level");
	}

	public void setStuMotherEmail(String stuMotherEmail){
		this.stuMotherEmail = stuMotherEmail;
		saveShared.saveElement("stu_mother_email",stuNationalId);
	}

	public String getStuMotherEmail(){
		return saveShared.getPreferences("stu_mother_email");
	}

	public void setStuFaGuaPhone1(String stuFaGuaPhone1){
		this.stuFaGuaPhone1 = stuFaGuaPhone1;
		saveShared.saveElement("stu_fa_gua_phone1",stuNationalId);
	}

	public String getStuFaGuaPhone1(){
		return saveShared.getPreferences("stu_fa_gua_phone1");
	}

	public void setStuBus(String stuBus){
		this.stuBus = stuBus;
		saveShared.saveElement("stu_bus",stuNationalId);
	}

	public String getStuBus(){
		return saveShared.getPreferences("stu_bus");
	}

	public void setStuFname(String stuFname){
		this.stuFname = stuFname;
		saveShared.saveElement("stu_fname",stuNationalId);
	}

	public String getStuFname(){
		return saveShared.getPreferences("stu_fname");
	}

	public void setStuGuardian(String stuGuardian){
		this.stuGuardian = stuGuardian;
		saveShared.saveElement("stu_guardian",stuNationalId);
	}

	public String getStuGuardian(){
		return saveShared.getPreferences("stu_guardian");
	}

	public void setStuMotherOccup(String stuMotherOccup){
		this.stuMotherOccup = stuMotherOccup;
		saveShared.saveElement("stu_mother_occup",stuNationalId);
	}

	public String getStuMotherOccup(){
		return saveShared.getPreferences("stu_mother_occup");
	}

	public void setStuMedicalInfo(String stuMedicalInfo){
		this.stuMedicalInfo = stuMedicalInfo;
		saveShared.saveElement("stu_medical_info",stuNationalId);
	}

	public String getStuMedicalInfo(){
		return saveShared.getPreferences("stu_medical_info");
	}

	public void setStuPhoto(String stuPhoto){
		this.stuPhoto = stuPhoto;
		saveShared.saveElement("stu_photo",stuNationalId);
	}

	public String getStuPhoto(){
		return saveShared.getPreferences("stu_photo");
	}

	public void setStuNationality(String stuNationality){
		this.stuNationality = stuNationality;
		saveShared.saveElement("stu_nationality",stuNationalId);
	}

	public String getStuNationality(){
		return saveShared.getPreferences("stu_nationality");
	}

	public void setStuAddress(String stuAddress){
		this.stuAddress = stuAddress;
		saveShared.saveElement("stu_address",stuNationalId);
	}

	public String getStuAddress(){
		return saveShared.getPreferences("stu_address");
	}

	public void setStuEmergName(String stuEmergName){
		this.stuEmergName = stuEmergName;
		saveShared.saveElement("stu_emerg_name",stuNationalId);
	}

	public String getStuEmergName(){
		return saveShared.getPreferences("stu_emerg_name");
	}

	public void setStuNationalId(String stuNationalId){
		this.stuNationalId = stuNationalId;
		saveShared.saveElement("stu_national_id",stuNationalId);
	}

	public String getStuNationalId(){
		//return stuNationalId;
		return saveShared.getPreferences("stu_national_id");
	}

	public void setBroSisName(String broSisName){
		this.broSisName = broSisName;
		saveShared.saveElement("bro_sis_name",stuNationalId);
	}

	public String getBroSisName(){
		return saveShared.getPreferences("bro_sis_name");
	}

	public void setStuFaGuaEmail(String stuFaGuaEmail){
		this.stuFaGuaEmail = stuFaGuaEmail;
		saveShared.saveElement("stu_fa_gua_email",stuNationalId);
	}

	public String getStuFaGuaEmail(){
		return saveShared.getPreferences("stu_fa_gua_email");
	}

	public void setStuReligion(String stuReligion){
		this.stuReligion = stuReligion;
		saveShared.saveElement("stu_religion",stuNationalId);
	}

	public String getStuReligion(){
		return saveShared.getPreferences("stu_religion");
	}

	public void setStuBirthDate(String stuBirthDate){
		this.stuBirthDate = stuBirthDate;
		saveShared.saveElement("stu_birth_date",stuNationalId);
	}

	public String getStuBirthDate(){
		return saveShared.getPreferences("stu_birth_date");
	}

	public void setStuEmergRelation(String stuEmergRelation){
		this.stuEmergRelation = stuEmergRelation;
		saveShared.saveElement("stu_emerg_relation",stuNationalId);
	}

	public String getStuEmergRelation(){
		return saveShared.getPreferences("stu_emerg_relation");
	}

	public void setStuMotherName(String stuMotherName){
		this.stuMotherName = stuMotherName;
		saveShared.saveElement("stu_mother_name",stuNationalId);
	}

	public String getStuMotherName(){
		return saveShared.getPreferences("stu_mother_name");
	}

	public void setBroSisGrade(String broSisGrade){
		this.broSisGrade = broSisGrade;
		saveShared.saveElement("bro_sis_grade",stuNationalId);
	}

	public String getBroSisGrade(){
		return saveShared.getPreferences("bro_sis_grade");
	}

	public void setStuEmergPhone(String stuEmergPhone){
		this.stuEmergPhone = stuEmergPhone;
		saveShared.saveElement("stu_emerg_phone",stuNationalId);
	}

	public String getStuEmergPhone(){
		return saveShared.getPreferences("stu_emerg_phone");
	}

	public void setStuBirthPhoto(String stuBirthPhoto){
		this.stuBirthPhoto = stuBirthPhoto;
		saveShared.saveElement("stu_birth_photo",stuNationalId);
	}

	public String getStuBirthPhoto(){
		return saveShared.getPreferences("stu_birth_photo");
	}

	public void setStuFaGuaName(String stuFaGuaName){
		this.stuFaGuaName = stuFaGuaName;
		saveShared.saveElement("stu_fa_gua_name",stuNationalId);
	}

	public String getStuFaGuaName(){
		return saveShared.getPreferences("stu_fa_gua_name");
	}

	public void setStuFaGuaOccup(String stuFaGuaOccup){
		this.stuFaGuaOccup = stuFaGuaOccup;
		saveShared.saveElement("stu_fa_gua_occup",stuNationalId);
	}

	public String getStuFaGuaOccup(){
		return saveShared.getPreferences("stu_fa_gua_occup");
	}

	public void setStuTransferredSch(String stuTransferredSch){
		this.stuTransferredSch = stuTransferredSch;
		saveShared.saveElement("stu_transferred_sch",stuNationalId);
	}

	public String getStuTransferredSch(){
		return saveShared.getPreferences("stu_transferred_sch");
	}

	public void setStuMotherPhone1(String stuMotherPhone1){
		this.stuMotherPhone1 = stuMotherPhone1;
		saveShared.saveElement("stu_mother_phone1",stuNationalId);
	}

	public String getStuMotherPhone1(){
		return saveShared.getPreferences("stu_mother_phone1");
	}

	public void setStuGender(String stuGender){
		this.stuGender = stuGender;
		saveShared.saveElement("stu_gender",stuNationalId);
	}

	public String getStuGender(){
		return saveShared.getPreferences("stu_gender");
	}

	public void setStuMoQualPhoto(String stuMoQualPhoto){
		this.stuMoQualPhoto = stuMoQualPhoto;
		saveShared.saveElement("stu_mo_qual_photo",stuNationalId);
	}

	public String getStuMoQualPhoto(){
		return saveShared.getPreferences("stu_mo_qual_photo");
	}

	public void setStuSecLang(String stuSecLang){
		this.stuSecLang = stuSecLang;
		saveShared.saveElement("stu_sec_lang",stuNationalId);
	}

	public String getStuSecLang(){
		return saveShared.getPreferences("stu_sec_lang");
	}

	public void setStuMoIdPhoto(String stuMoIdPhoto){
		this.stuMoIdPhoto = stuMoIdPhoto;
		saveShared.saveElement("stu_mo_id_photo",stuNationalId);
	}

	public String getStuMoIdPhoto(){
		return saveShared.getPreferences("stu_mo_id_photo");
	}

	public void setStuFaIdPhoto(String stuFaIdPhoto){
		this.stuFaIdPhoto = stuFaIdPhoto;
		saveShared.saveElement("stu_fa_id_photo",stuNationalId);
	}

	public String getStuFaIdPhoto(){
		return saveShared.getPreferences("stu_fa_id_photo");
	}

	public boolean isLoged() {
		return saveShared.isLoged();
	}

	public void clear(){saveShared.clear();}

	@Override
 	public String toString(){
		return 
			"SendAdmission{" + 
			"stu_fa_qual_photo = '" + stuFaQualPhoto + '\'' + 
			",stu_parents_status = '" + stuParentsStatus + '\'' + 
			",stu_faname = '" + stuFaname + '\'' + 
			",stu_level = '" + stuLevel + '\'' + 
			",stu_mother_email = '" + stuMotherEmail + '\'' + 
			",stu_fa_gua_phone1 = '" + stuFaGuaPhone1 + '\'' + 
			",stu_bus = '" + stuBus + '\'' + 
			",stu_fa_gua_phone2 = '" + stuFaGuaPhone2 + '\'' + 
			",stu_fname = '" + stuFname + '\'' + 
			",stu_guardian = '" + stuGuardian + '\'' + 
			",stu_mother_occup = '" + stuMotherOccup + '\'' + 
			",stu_medical_info = '" + stuMedicalInfo + '\'' + 
			",stu_photo = '" + stuPhoto + '\'' + 
			",stu_nationality = '" + stuNationality + '\'' + 
			",stu_address = '" + stuAddress + '\'' + 
			",stu_emerg_name = '" + stuEmergName + '\'' + 
			",stu_national_id = '" + stuNationalId + '\'' + 
			",bro_sis_name = '" + broSisName + '\'' + 
			",stu_fa_gua_email = '" + stuFaGuaEmail + '\'' + 
			",stu_religion = '" + stuReligion + '\'' + 
			",stu_birth_date = '" + stuBirthDate + '\'' + 
			",stu_emerg_relation = '" + stuEmergRelation + '\'' + 
			",stu_mother_name = '" + stuMotherName + '\'' + 
			",bro_sis_grade = '" + broSisGrade + '\'' + 
			",stu_emerg_phone = '" + stuEmergPhone + '\'' + 
			",stu_birth_photo = '" + stuBirthPhoto + '\'' + 
			",stu_lname = '" + stuLname + '\'' + 
			",stu_fa_gua_name = '" + stuFaGuaName + '\'' + 
			",stu_fa_gua_occup = '" + stuFaGuaOccup + '\'' + 
			",stu_transferred_sch = '" + stuTransferredSch + '\'' + 
			",stu_mother_phone1 = '" + stuMotherPhone1 + '\'' + 
			",stu_gender = '" + stuGender + '\'' + 
			",stu_mother_phone2 = '" + stuMotherPhone2 + '\'' + 
			",stu_mo_qual_photo = '" + stuMoQualPhoto + '\'' + 
			",stu_sec_lang = '" + stuSecLang + '\'' + 
			",stu_mo_id_photo = '" + stuMoIdPhoto + '\'' + 
			",stu_fa_id_photo = '" + stuFaIdPhoto + '\'' + 
			"}";
		}
}