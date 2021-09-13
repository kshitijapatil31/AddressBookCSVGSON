package com.bridgelabz.addressbook;

import java.util.ArrayList;

public class AddressBook {

	
	static String firstName;
	String lastName;
	String address;
	String city;
	String state;
	Object zip;
	String phoneNo;
	String emailId;
	
	public AddressBook() {
		
	}
	
	public AddressBook(String firstName, String lastName, String address, String city, String state, Object zip,
			String phoneNo, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	@Override
	public String toString() {
		return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", emailId=" + emailId + "]";
	}

	

}