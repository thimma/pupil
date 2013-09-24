package com.pupil.model;

public class StudentContactDetails {
	private String aNumber;
	private String address;
	private String phoneNumber;
	private String mobileNumber;
	private String city;
	private String state;
	private int zip;
	private String country;
	
	public void setANumber(String aNum){
		aNumber=aNum;
	}
	
	public void setAddress(String add){
		address=add;
	}
	
	public void setPhoneNumber(String phNo){
		phoneNumber=phNo;
	}
	
	public void setMobileNumber(String mobNo){
		mobileNumber=mobNo;
	}
	
	public void setCity(String cit){
		city=cit;
	}
	
	public void setState(String st){
		state=st;
	}
	
	public void setZip(int zipcode){
		zip=zipcode;
	}
	
	public void setCountry(String cuntry){
		country=cuntry;
	}
	
	public String getANumber(){
		return aNumber;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getMobileNumber(){
		return mobileNumber;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}
	
	public int getZip(){
		return zip;
	}
	
	public String getCountry(){
		return country;
	}
	
}
