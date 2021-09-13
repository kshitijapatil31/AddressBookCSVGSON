package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class AddressBookFileIOService {
	
	public static String PAYROLL_FILE_NAME="addressBook-file.txt";
	
	public void writeData(List<AddressBook> addressBookList) {
		StringBuffer addressbookBuffer=new StringBuffer();
		addressBookList.forEach(employee->{
			String addressBookDataString =employee.toString().concat("\n");
			addressbookBuffer.append(addressBookDataString);
		});
			try {
				Files.write(Paths.get(PAYROLL_FILE_NAME),addressbookBuffer.toString().getBytes());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void printData() {
		  
			try {
				Files.lines(new File("addressBook-file.txt").toPath())
				.forEach(System.out::println);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public long countEntries() {
			long entries=0;
			try {
				entries=Files.lines(new File("addressBook-file.txt").toPath()).count();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return entries;
		}
		public List<AddressBookFileIOService> readData(){
			List<AddressBookFileIOService> addressBookList=new ArrayList<>();
			try {
				Files.lines(new File("addressBook-file.txt").toPath())
				.map(line->line.trim())
				.forEach(line->System.out.println(line));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			return addressBookList;
			
		}

	}

