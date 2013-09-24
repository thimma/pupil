package com.pupil.model;

public class StudentAccountDetails {
	
	private int accountId;
	private String userGroupCd;
	private String firstName;
	private String lastName;
	private String emailId;
	private String aNumber;
	
	public void setAccountId(int accId){
		accountId=accId;
	}
	
	public void setUserGroupCd(String ugcd){
		userGroupCd=ugcd;
	}
	
	public void setFirstName(String fName){
		firstName=fName;
	}
	
	public void setLastName(String lName){
		lastName=lName;
	}
	
	public void setEmailId(String emId){
		emailId=emId;
	}
	
	public void setANumber(String aNum){
		aNumber=aNum;
	}
	
	public int getAccountId(){
		return accountId;
	}
	
	public String getUserGroupCd(){
		return userGroupCd;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmailId(){
		return emailId;
	}
	
	public String getANumber(){
		return aNumber;
	} 
	
}
