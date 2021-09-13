package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookOpenCSV {
	static String SAMPLE_CSV_FILE="addressbook.csv";
	

	
	  public static void readData()
	    {
		  try {
			Reader reader =Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
			CSVReader csvReader=new CSVReader(reader);
		
			List<String[]> nextRecord=csvReader.readAll();
			nextRecord.stream().forEach(record->{
				System.out.println(record[0]);
				System.out.println(record[1]);
				System.out.println(record[2]);
				System.out.println(record[3]);
				System.out.println(record[4]);
				System.out.println(record[5]);
				System.out.println(record[6]);
				System.out.println(record[7]);
			});
			csvReader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	    	
	    }
	  public static void writeData()
	    {
         
	        File file = new File(SAMPLE_CSV_FILE);

	        try {
	            
	            FileWriter writerfile = new FileWriter(file);

	           
	            CSVWriter writer = new CSVWriter(writerfile);

	            
	            List<String[]> data = new ArrayList<String[]>();
	            data.add(new String[] {"firstName","lastName" ,"address" ,"city","state","zipCode","phoneNumber","email"});
	        
	            data.add(new String[] { "kshitija", "Patil", "mirjole","ratnagiri","Maharashtra","965453","908765433","patilksh@gmail" });
	            data.add(new String[] { "kshitija", "Patil", "mirjole","ratnagiri","Maharashtra","40975","86543246","kshitij@gmail.com"});
	            data.add(new String[] { "kshitija", "Patil", "mirjole","ratnagiri","Maharashtra","087567","9876589342","kshitija@mn.com"});
	            writer.writeAll(data);

	          
	            writer.close();
	        }
	        catch (IOException e) {
	           
	            e.printStackTrace();
	        }
	    }
	  
	  public static void main(String []args) throws IOException {
			readData();
			writeData();
		}
	}

