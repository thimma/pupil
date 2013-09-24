package com.pupil.model;

public class StudentCurrentProgram {
	
	private String aNumber;
	private String currentProgram;
	private String level;
	private String expectedGradDate;
	private String college;
	private String campus;
	private String major;
	private String department;
	
	public void setANumber(String aNum){
		aNumber=aNum;
	}
	
	public void setCurrentProgram(String curProg){
		currentProgram=curProg;
	}
	
	public void setLevel(String lvl){
		level=lvl;
	}
	
	public void setExpectedGradDate(String expGradDate){
		expectedGradDate=expGradDate;
	}
	
	public void setCollege(String coll){
		college=coll;
	}
	
	public void setCampus(String camp){
		campus=camp;
	}
	
	public void setMajor(String maj){
		major=maj;
	}
	
	public void setdepartment(String dep){
		department=dep;
	}
	
	public String getANumber(){
		 return aNumber;
	}
	
	public String getCurrentProgram(){
		return currentProgram;
	}
	
	public String getLevel(){
		return level;
	}
	
	public String getExpectedGradDate(){
		return expectedGradDate;
	}
	
	public String getCollege(){
		return college;
	}
	
	public String getCampus(){
		return campus;
	}
	
	public String getMajor(){
		return major;
	}
	
	public String getdepartment(){
		return department;
	}
	
	
}
