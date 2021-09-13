package com.bridgelabz.addressbook;
import com.opencsv.bean.CsvBindByName;

public class CSVAddressBook {
	
	@CsvBindByName
	static String firstName;
	
	@CsvBindByName
	String lastName;
	
	@CsvBindByName
	String address;
	
	@CsvBindByName
	String city;
	
	@CsvBindByName
	String state;
	
	@CsvBindByName
	Object zip;
	
	@CsvBindByName
	String phoneNo;
	
	@CsvBindByName
	String emailId;

	@Override
	public String toString() {
		return "CSVAddressBook [lastName=" + lastName + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", phoneNo=" + phoneNo + ", emailId=" + emailId + "]";
	}
	
	
}
