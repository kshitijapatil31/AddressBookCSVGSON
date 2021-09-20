package com.bridgelabz.addressbooktest;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.addressbook.AddressBook;
import com.bridgelabz.addressbook.AddressBookService;
import com.bridgelabz.addressbook.IOService;



public class AddressBookTest {
	
	AddressBookService addressBookService;
	@Test
	public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
		AddressBook[] arrayOfEmps= {
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
		};
		
		addressBookService=new AddressBookService(Arrays.asList(arrayOfEmps));
		addressBookService.writeEmployeePayrollData(IOService.FILE_IO);
		addressBookService.printData(IOService.FILE_IO);
		
		
	
	}
	
	@Test
	public void givenAddressBook_whenRetriveAllAddressBookData_shouldReturnAdressBookCount() {
		addressBookService=new AddressBookService();
		List<AddressBook> addressBook=addressBookService.readAddressBookData(IOService.DB_IO);
		Assert.assertEquals(5,addressBook.size());
	}
}