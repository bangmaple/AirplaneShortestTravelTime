/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Airport;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author bangmaple
 */
public class AirportManager {

    static List<Airport> list;

    public AirportManager() {
        list = new ArrayList<>();
    }

    public void loadData() {
        String fileName = "airport-data.txt";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(s, " \t");
                while (stk.hasMoreTokens()) {
                    Airport a = new Airport();
                    a.setAirportName(stk.nextToken());
                    a.setTimeZone(Integer.parseInt(stk.nextToken()));
                    list.add(a);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Data is not valid.");
        }
    }

    public void printAll() {
        for (int i = 0, count = 1; i < list.size(); i++, count++) {
            System.out.print(list.get(i) + " ");
            if (count % 6 == 0) {
                System.out.print("\n");
            }
        }
        System.out.println("");
    }

    public static String getTimeZone(String airportName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAirportName().equalsIgnoreCase(airportName)) {
                return String.valueOf(list.get(i).getTimeZone());
            }
        }
        return "";
    }

    public String search(String name) {
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).getAirportName());
            if (name.equalsIgnoreCase(list.get(i).getAirportName())) {
                //System.out.println(list.get(i).getAirportName());
                return list.get(i).getAirportName();
            }
        }
        return name;
    }
}
