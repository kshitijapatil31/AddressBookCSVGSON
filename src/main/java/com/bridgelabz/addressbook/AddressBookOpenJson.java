package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.stream.JsonWriter;

public class AddressBookOpenJson {
	
	
public static void writeData() {
	 String AddressbookFile="addressbookjson.json";
     try(FileWriter fileWriter = new FileWriter(AddressbookFile);
         JsonWriter jsonWriter = new JsonWriter(fileWriter)
     ) {
         jsonWriter.beginObject();
         jsonWriter.name("firstName").value("kshitija");
         jsonWriter.name("lastName").value("patil");
         jsonWriter.name("address").value("mirjole");
         jsonWriter.name("city").value("Ratnagiri");
         jsonWriter.name("state").value("Maharashtra");
         jsonWriter.name("zip").value("415639");
         jsonWriter.name("phoneNo").value("987665432");
         jsonWriter.name("emailId").value("patilkshitija2@gmail.com");
         jsonWriter.endObject();

         
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
public static void readData() {
	 try {
         Files.lines(new File("addressbookjson.json").toPath())
                 .forEach(System.out::println);
     }catch(IOException e) {
         e.printStackTrace();
     }
}
	public static void main(String[] args) {
		
		writeData();
		readData();
	}

}
