package com.bridgelabz.addressbook;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressBookDBService {
	AddressBookDBConnection addressBook = new AddressBookDBConnection();
	private  PreparedStatement addressBookDataStatement;
	
	
	public List<AddressBook> readData() {
		String sql = "select * from addressBook";
		List<AddressBook> addressBookList = new ArrayList<>();
		try(Connection con = addressBook.dataBaseconnection()) {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			addressBookList=this.getAddressBook(rs);
			while (rs.next()) {
				int id = rs.getInt("Id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String type = rs.getString("type");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String phoneNo = rs.getString("phoneNumber");
				String emailId = rs.getString("emailId");

				System.out.println(firstName + " " + lastName + " " + type + " " + address + " " + city + " " + state
						+ " " + phoneNo + " " + emailId);
				addressBookList.add(new AddressBook(firstName , lastName ,type , address , city, state, phoneNo ,emailId));
                 con.close();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addressBookList;
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
				String phoneNo = rs.getString("phoneNumber");
				String emailId = rs.getString("emailId");

				System.out.println(firstName + " " + lastName + " " + type + " " + address + " " + city + " " + state
						+ " " + phoneNo + " " + emailId);
				addressBookList.add(new AddressBook(firstName , lastName ,type , address , city, state, phoneNo ,emailId));
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	



}
