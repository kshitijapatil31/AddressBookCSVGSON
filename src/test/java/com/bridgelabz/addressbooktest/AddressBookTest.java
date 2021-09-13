package com.bridgelabz.addressbooktest;

import java.util.Arrays;

import org.junit.Test;

import com.bridgelabz.addressbook.AddressBook;
import com.bridgelabz.addressbook.AddressBookService;
import com.bridgelabz.addressbook.IOService;



public class AddressBookTest {
	@Test
	public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
		AddressBook[] arrayOfEmps= {
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
				new AddressBook("kshitija","patil","Mirjole","Ratnagiri","Maharastra",415639,"8974562","patil@gmail.com"),
		};
		AddressBookService employeePayrollService;
		employeePayrollService=new AddressBookService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    	employeePayrollService.printData(IOService.FILE_IO);
		
		
	
	}
}