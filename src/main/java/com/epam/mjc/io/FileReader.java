package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file)  {
        String profileData = getDataFromTxt(file);

        String[] lines = profileData.split("\r\n");
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
            }
        }
        return p;
    }

    private String getDataFromTxt (File file)  {
        java.io.FileReader inputStream = null;
        String profileTxt = "";

        try {
            inputStream = new java.io.FileReader(file);

            int c;
            while ((c = inputStream.read()) != -1) {
                profileTxt += ""+ (char)c;
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if(inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }

            }
        }

        return profileTxt;
    }
}
