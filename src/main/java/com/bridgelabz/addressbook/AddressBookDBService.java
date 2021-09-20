package com.bridgelabz.addressbook;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressBookDBService {
	static AddressBookDBConnection addressBook = new AddressBookDBConnection();
	private  PreparedStatement addressBookDataStatement;
	
	
	public List<AddressBook> readData() {
		String sql = "select * from addressBook";

	    return this.getAddressBookDataUsingDB(sql);
	}

	public int updateAddressBookData(String firstName,String address) {
		return this.updateData(firstName,address);
	}
	public int updateData(String firstName, String address) {
		String sql = String.format(
				"update addressBook set address='%.2f'where firstName='%s';", address,firstName);
		try(Connection con = addressBook.dataBaseconnection()){
			Statement stmt = con.createStatement();
			return stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}

	private void preparedStatementForAddressBook() {
		try {
			Connection con = addressBook.dataBaseconnection();
		String sql="select * from addressbook where firstName=?";
			addressBookDataStatement=con.prepareStatement(sql);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<AddressBook> getAddressBook(String string) {
		List<AddressBook> addressBookList=null;
		if(this.addressBookDataStatement==null) {
			this.preparedStatementForAddressBook();
			try {
				addressBookDataStatement.setString(1,string);
				ResultSet rs=addressBookDataStatement.executeQuery();
				addressBookList=this.getAddressBook(rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return addressBookList;
	}

	private List<AddressBook> getAddressBook(ResultSet rs) {
		List<AddressBook> addressBookList = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("Id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String type = rs.getString("type");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				Object zip=rs.getObject("zip");
				String phoneNo = rs.getString("phoneNumber");
				String emailId = rs.getString("emailId");
String date=rs.getString("start");
				System.out.println(firstName + " " + lastName + " " + type + " " + address + " " + city + " " + state
						+ " " + phoneNo + " " + emailId);
				addressBookList.add(new AddressBook(firstName , lastName ,type , address , city, state,zip, phoneNo ,emailId,date));
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<AddressBook> getAddressBookForDateRange(Date startDate, Date endDate) {
		String sql=String.format("select * from addressbook where start between '%s' and '%s';",startDate,endDate);
			

	    return this.getAddressBookDataUsingDB(sql);
	}

	private List<AddressBook> getAddressBookDataUsingDB(String sql) {
		List<AddressBook> addressBookList = new ArrayList<>();
		try(Connection con = addressBook.dataBaseconnection()) {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			addressBookList=this.getAddressBook(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addressBookList;
	}

	public static AddressBook addAddressBookData(String firstname, String lastname, String address, String city,
			String state, Object zip, String phonenumber, String emailId, String date) {
		int id=-1;
		AddressBook addressBookNo=null;
		String sql=String.format("insert into addressbook (firstname, lastname,  address,  city,  state,  zip,  phonenumber,  emailId,  date)values('%s','%s','%s','%s','%s','%s','%s','%s','%s')",firstname, lastname,  address,  city,  state,  zip,  phonenumber,  emailId,  date);
       try(Connection con = addressBook.dataBaseconnection()) {
			
			Statement stmt = con.createStatement();
			int row=stmt.executeUpdate(sql,stmt.RETURN_GENERATED_KEYS);
			
			if(row==1)
			{ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				id=rs.getInt(1);
			}
			addressBookNo=new AddressBook(firstname, lastname,  address,  city,  state,  zip,  phonenumber,  emailId,  date);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addressBookNo;
	}

	



}