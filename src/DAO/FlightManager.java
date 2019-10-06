/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Flight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author bangmaple
 */
public class FlightManager {

    List<Flight> list;

    public FlightManager() {
        list = new ArrayList<>();
    }

    public void loadData() {
        String filename = "flight-data.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                s = s.trim();
                StringTokenizer stk = new StringTokenizer(s, " \t");
                while (stk.hasMoreTokens()) {
                    Flight f = new Flight();
                    f.setAirlineName(stk.nextToken());
                    f.setFlight(stk.nextToken());
                    f.setOriginAirPort(stk.nextToken());
                    f.setDepartureTime(stk.nextToken() + stk.nextToken());
                    f.setDestinationAirport(stk.nextToken());
                    f.setArrivalTime(stk.nextToken() + stk.nextToken());
                    list.add(f);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Data is not valid.");
        }
    }

    public void printAll() {
        boolean flag = true;
        for (int i = 0, count = 1; i < list.size(); i++, count++) {
            System.out.print(list.get(i) + "    ");
            if (count % 2 == 0) {
                System.out.print("\n");
            }
            if (flag) {
                if (count % 350 == 0) {
                    System.out.println("Flight: " + count + "/" + list.size());
                    System.out.println("Do you want to see more ? (Y/N/A): ");
                    Scanner sc = new Scanner(System.in);
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("n")) {
                        break;
                    } else if (choice.equalsIgnoreCase("a")) {
                        flag = false;
                    }
                }
            }
        }
    }

    public String search(String name, String oriAirport) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDestinationAirport().equalsIgnoreCase(name)
                    && list.get(i).getOriginAirPort().equalsIgnoreCase(oriAirport)) {
                return list.get(i).getDestinationAirport();
            }
        }
        return "";
    }

    public String availableDestinationAirport(String oriAirport) {
        TreeSet<String> ts = new TreeSet<>();
        String string = "[ ";
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (oriAirport.equalsIgnoreCase(list.get(i).getOriginAirPort())) {
                ts.add(list.get(i).getDestinationAirport());
            }
        }
        TreeSet<String> nTS = (TreeSet<String>) ts.clone();
        int size = ts.size();
        System.out.print("(" + size + ")" + "\n" + ts);
        System.out.println("");
        for (int i = 0; i < size; i++) {
            String test = ts.pollFirst();
            for (int j = 0; j < list.size(); j++) {
                if (oriAirport.equalsIgnoreCase(list.get(j).getOriginAirPort())
                        && test.equalsIgnoreCase(list.get(j).getDestinationAirport())) {
                    ++count;
                }
            }
            string += nTS.pollFirst() + " " +count +", ";
            count = 0;
        }
        return string + "]";
    }
}
