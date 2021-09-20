package com.bridgelabz.addressbook;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Enumeration;

public class AddressBookDBConnection {
	
	private static AddressBookDBConnection addressBookDBConnection;
	private PreparedStatement addressBookDataStatement;
	Connection con;
	
	
	static AddressBookDBConnection getInstance() {
		if(addressBookDBConnection==null) 
			addressBookDBConnection=new AddressBookDBConnection();
			return addressBookDBConnection;
			
		
	}
	public Connection dataBaseconnection(){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/addressbook?useSSL=false";
		String username="root";
		String password="edac20";

	try {
		Class.forName(driver);
		
	}catch(Exception e) {
		throw new IllegalStateException("driver not found");
		
	}
	listDrivers();

	try {
		con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		
		
	}catch(Exception e) {
		System.out.println(e);
		
	}
	return con;
	}

	private static void listDrivers() {
	
		Enumeration<Driver> driverList=DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass=(Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
		
	}
}