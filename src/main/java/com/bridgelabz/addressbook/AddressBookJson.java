package com.bridgelabz.addressbook;

public class AddressBookJson {

	
	static String firstName;
	String lastName;
	String address;
	String city;
	String state;
	Object zip;
	String phoneNo;
	String emailId;
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		AddressBookJson.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getZip() {
		return zip;
	}
	public void setZip(Object zip) {
		this.zip = zip;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
