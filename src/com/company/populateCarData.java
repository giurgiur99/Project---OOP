package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class populateCarData  {
    public static void populate(ArrayList<CarData> carList)
    {
        try {
            File myObj = new File("file.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                CarData carData = new CarData();

                String licensePlate = myReader.next();
                String maker = myReader.next();
                String owner = myReader.next();
                String phoneNumber = myReader.next();
                String date = myReader.next(); //(Day/Month/Year)


                carData.LicensePlate = licensePlate;
                carData.Maker = maker;
                carData.Owner = owner;
                carData.PhoneNumber = phoneNumber;
                carData.Date = date;

                carList.add(carData);
            }
            myReader.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
