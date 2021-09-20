package com.bridgelabz.addressbook;

import java.util.ArrayList;

public class AddressBook {

	
	static String firstName;
	String lastName;
	String type;
	String address;
	String city;
	String state;
	Object zip;
	String phoneNumber;
	String emailId;
	String date;
	public AddressBook() {
		
	}
	
	public AddressBook(String firstName, String lastName, String address, String city, String state, Object zip,
			String phoneNo, String emailId,String date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNo;
		this.emailId = emailId;
		this.date=date;
	}
	
	
	public AddressBook(String firstName,String lastName, String type, String address, String city, String state, Object zip,
			String phoneNo, String emailId,String date) {
		this(firstName,lastName, address, city,  state,  zip, phoneNo,  emailId,date);
		this.type = type;
		
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
		return phoneNumber;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNumber = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

	

	@Override
	public String toString() {
		return "AddressBook [lastName=" + lastName + ", type=" + type + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", date=" + date + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	

	

}