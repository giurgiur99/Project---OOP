package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {

    public static void main(String[] args) {

    ArrayList <CarData> carList = new ArrayList<CarData>();
    populateCarData.populate(carList);
    for(int i = 0 ; i < carList.size() ; i ++)
        System.out.println(carList.get(i).Owner + " " + carList.get(i).Maker + "  " + carList.get(i).LicensePlate);

    }
}
