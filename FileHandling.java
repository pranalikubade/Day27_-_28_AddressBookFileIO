package com.bridgelabz;

import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
    public void writeIntoFile(String adBookName, AddressBook addressBook) throws FileNotFoundException {
        Path path = Paths.get("C:\\Users\\LENOVO\\IdeaProjects\\Day_27AddressBookFileIO\\src\\com\\bridgelabz\\ContactBook");
        try {
            String data = "";
            for (Contacts contact: addressBook.contactList) {
                data += contact.toString();
            }
            java.nio.file.Files.write(path,data.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void readFromFile(){
        Path path = Paths.get("C:\\Users\\LENOVO\\IdeaProjects\\Day_27AddressBookFileIO\\src\\com\\bridgelabz\\ContactBook");
        try {
            System.out.println(Files.readAllLines(path));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //uc14
     public void writeToCSV(AddressBook addressBook) {
        try {
        CSVWriter write = null;
        try {
            write = new CSVWriter(new FileWriter("C:\\Users\\Day_27AddressBookFileIO\\IdeaProjects\\src\\com\\bridgelabz\\ContactBook.csv"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        for (Contacts contact : AddressBook.contactList) {
                String[] data = new String[]{contact.firstName, contact.lastName, contact.address, contact.city, contact.state, contact.email, contact.phoneNo};
                write.writeNext(data);
            }
            System.out.println("Data written into csv file");
            write.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void readFromCSV(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\LENOVO\\IdeaProjects\\Day_27AddressBookFileIO\\src\\com\\bridgelabz\\Contacts.csv"));
            String data = "";
            while((data = reader.readLine()) != null) {
                String[] values = data.split(",");
                for (int i = 0; i < values.length; i++)
                    System.out.println(values[i]);
            }
            System.out.println(" ");
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
}

