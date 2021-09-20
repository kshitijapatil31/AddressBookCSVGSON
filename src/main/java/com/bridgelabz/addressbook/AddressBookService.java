package com.bridgelabz.addressbook;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookService {

	public List<AddressBook> addressBookList;
	AddressBookDBService addressBookDBService;
	private AddressBookDBConnection addressBookDBConnection;
	public AddressBookService() {
		addressBookDBConnection=AddressBookDBConnection.getInstance();
	}
	public AddressBookService(List<AddressBook> addressBookList) {
		this();
		this.addressBookList = addressBookList;
	}

	public static void main(String[] args) {

		ArrayList<AddressBook> addressBookList = new ArrayList<>();
		AddressBookService emp = new AddressBookService(addressBookList);
		Scanner input = new Scanner(System.in);
		emp.readEmployeeDetail(input, addressBookList);
		emp.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}

	public void readEmployeeDetail(Scanner sc, ArrayList<AddressBook> employee) {
		
		System.out.println("Enter the First Name");
		String firstName = sc.next();

		System.out.println("Enter the Last Name");
		String lastName = sc.next();

		System.out.println("Enter the address");
		String address = sc.next();

		System.out.println("Enter the city");
		String city = sc.next();

		System.out.println("Enter the state");
		String state = sc.next();

		System.out.println("Enter the zip");
		String zip = sc.next();

		System.out.println("Enter the Phone number");
		String phoneNo = sc.next();

		System.out.println("Enter the emailId");
		String emailId = sc.next();

		String date=sc.next();
		employee.add(
				new AddressBook(firstName, lastName, address, city, state, zip, phoneNo, emailId,date));

	}

	public void writeEmployeePayrollData(IOService IOService) {
		if (IOService.equals(IOService.CONSOLE_IO)) {
			System.out.println(addressBookList);
		} else if (IOService.equals(IOService.FILE_IO)) {

			new AddressBookFileIOService().writeData(addressBookList);
		}
	}

	public void printData(IOService IOService) {
		if (IOService.equals(IOService.FILE_IO))
			new AddressBookFileIOService().printData();
	}

	public List<AddressBook> readAddressBookData(IOService IOService) {
		 if (IOService.equals(IOService.DB_IO))
	
		this.addressBookList=new AddressBookDBService().readData();
		return this.addressBookList;
	}

	public void updateAddressBook(String firstName, String address) {
		int result=new AddressBookDBService().updateAddressBookData(firstName,address);
		if(result==0)
			return;
		AddressBook addressBook=this.getAddressBook(firstName);
		if(addressBook !=null)
			addressBook.phoneNumber=address;
	}

	private AddressBook getAddressBook(String firstName) {
		
		return this.addressBookList.stream()
				.filter(n->n.firstName.equals(firstName))
				.findFirst()
				.orElse(null);
	}

	public boolean checkAddressBookSyncDB(String string) {
		List<AddressBook> addressbookList=new AddressBookDBService().getAddressBook(string);
		return addressbookList.get(0).equals(getAddressBook(string));
	}

	
	public List<AddressBook> readAddressBookDataDateRange(IOService ioService, Date startDate, Date endDate) {
		 if (ioService.equals(IOService.DB_IO))
		return new AddressBookDBService().getAddressBookForDateRange(startDate,endDate);
		 return null;
	}
	
	public void addAddressBookData(String firstname, String lastname, String address, String city, String state, Object zip,
			String phonenumber, String emailId, String date) {
		addressBookList.add(AddressBookDBService.addAddressBookData( firstname,  lastname,  address,  city,  state,  zip,
			 phonenumber,  emailId,  date) );
		
	}
	

}