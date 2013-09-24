package com.pupil.model;

public class Job {
	
	private int job_uid;
	private String job_id;
	private String employer_id;
	private String job_description;
	private String job_creation_date;
	private String job_location;
	private String parttime_fulltime;
	private String job_summary;
	private String contact_person_name;
	private String contact_person_email;
	private String others;
	private String contact_person_phone;
	private String is_job_open;
	
	public void setJob_uid(int jobuId){
		job_uid=jobuId;
	}
	
	public void setJob_id(String jobId){
		job_id=jobId;
	}
	
	public void setEmployer_id(String employerId){
		employer_id=employerId;
	}
	
	public void setJob_description(String jobDescription){
		job_description=jobDescription;
	}
	
	public void setJob_creation_date(String jobCreationDate){
		job_creation_date=jobCreationDate;
	}
	
	public void setJob_location(String jobLocation){
		job_location=jobLocation;
	}
	
	public void setParttime_fulltime(String parttimeFulltime){
		parttime_fulltime=parttimeFulltime;
	}
	
	public void setJob_summary(String jobSummary){
		job_summary=jobSummary;
	}
	
	public void setContact_person_name(String contactPersonName){
		contact_person_name=contactPersonName;
	}
	
	public void setContact_person_email(String contactPersonEmail){
		contact_person_email=contactPersonEmail;
	}
	
	public void setOthers(String othrs){
		others=othrs;
	}
	
	public void setContact_person_phone(String contactPersonPhone){
		contact_person_phone=contactPersonPhone;
	}
	
	public void setIs_job_open(String isJobOpen){
		is_job_open=isJobOpen;
	}
	
	public int getJob_uid(){
		return job_uid;
	}
	
	public String getJob_id(){
		return job_id;
	}
	
	public String getEmployer_id(){
		return employer_id;
	}
	
	public String getJob_description(){
		return job_description;
	}
	
	public String getJob_creation_date(){
		return job_creation_date;
	}
	
	public String getJob_location(){
		return job_location;
	}
	
	public String getParttime_fulltime(){
		return parttime_fulltime;
	}
	
	public String getJob_summary(){
		return job_summary;
	}
	
	public String getContact_person_name(){
		return contact_person_name;
	}
	
	public String getContact_person_email(){
		return contact_person_email;
	}
	
	public String getOthers(){
		return others;
	}
	
	public String getContact_person_phone(){
		return contact_person_phone;
	}
	
	public String getIs_job_open(){
		return is_job_open;
	}
	
	
}
