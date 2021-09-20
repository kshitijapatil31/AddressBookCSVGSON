package com.bridgelabz.addressbook;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressBookDBService {
	AddressBookDBConnection addressBook = new AddressBookDBConnection();

	public List<AddressBook> readData() {
		String sql = "select * from addressBook";
		List<AddressBook> addressBookList = new ArrayList<>();
		try {
			Connection con = addressBook.dataBaseconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addressBookList;
	}

}
