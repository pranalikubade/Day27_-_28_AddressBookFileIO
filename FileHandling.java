package com.bridgelabz;

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


}

