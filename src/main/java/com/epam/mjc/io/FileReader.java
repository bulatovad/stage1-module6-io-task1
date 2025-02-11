package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file)  {
       String[] lines = getLinesFromFile(file);
       Profile p = new Profile();
       for(String line: lines) {
           String[] data = line.split(": ");
           switch (data[0]) {
               case "Name":
                   p.setName(data[1]);
                   break;
               case "Age":
                   p.setAge(Integer.parseInt(data[1]));
                   break;
               case "Email":
                   p.setEmail(data[1]);
                   break;
               case "Phone":
                   p.setPhone(Long.parseLong(data[1]));
                   break;
               default:
                   break;
           }

       }
       return p;
    }

    private String[] getLinesFromFile (File file)  {
       String[] lines = new String[4];
        try(java.io.FileReader fr = new java.io.FileReader(file);
            BufferedReader br = new BufferedReader(fr);) {

            int num=0;
            String line;
            while ((line = br.readLine()) != null) {
                lines[num++] = line;
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
       return lines;
    }
}
