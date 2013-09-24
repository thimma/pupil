package com.pupil.model;

public class StudentResumeDetails {
	private String aNumber;
	private byte[] resume;
	private String coverLetter;
	
	public void setANumber(String aNum){
		aNumber=aNum;
	}
	
	public void setResume(byte[] res){
		resume=res;
	}
	
	public void setCoverLetter(String covLet){
		coverLetter=covLet;
	}
	
	public String getANumber(){
		 return aNumber;
	}
	
	public byte[] getResume(){
		return resume;
	}
	
	public String getCoverLetter(){
		return coverLetter;
	}
	
}
