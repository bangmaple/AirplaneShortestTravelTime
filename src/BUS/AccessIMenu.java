/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import BUS.IMenu;
import DAO.AirportManager;
import DAO.FlightManager;
import java.util.Scanner;

/**
 *
 * @author bangmaple
 */
public class AccessIMenu {

    private static Scanner sc = new Scanner(System.in);
    public static AirportManager am = new AirportManager();
    public static FlightManager fm = new FlightManager();
    static boolean flag = false;
    static boolean flagMain = false;

    public static void Menu() {
        while (true) {
            switch (IMenu.Menu()) {
                case 1:
                    if (!flagMain) {
                        loadAirportData();
                        loadFlightData();
                        successfully();
                        flagMain = true;
                    } else {
                        exist();
                    }
                    break;
                case 2:
                    if (flag) {
                        calculateShortestTimeTravel();
                    } else {
                        exception();
                    }
                    break;
                case 3:
                    if (flag) {
                        displayAirportData();
                    } else {
                        exception();
                    }
                    break;
                case 4:
                    if (flag) {
                        displayFlightData();
                    } else {
                        exception();
                    }
                    break;
                case 5:
                    exit();
            }
        }
    }

    private static void exit() {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("\nAre you sure want to exit ? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Thanks for using my program.");
                System.exit(0);
            } else if (choice.equalsIgnoreCase("n")) {
                BUS.IMenu.Menu();
            }
        }
    }

    private static void loadAirportData() {
        am.loadData();
    }

    private static void loadFlightData() {
        fm.loadData();
    }

    private static void calculateShortestTimeTravel() {
        String oriAirport = inputOriginAirport();
        System.out.print("\nDestination Airport ");
        System.out.println(fm.availableDestinationAirport(oriAirport));
        String desAirport = inputDestinationAirport(oriAirport);
        System.out.println(oriAirport + " " + desAirport);
        System.out.println("ok");
    }

    private static void displayAirportData() {
        am.printAll();
    }

    private static void displayFlightData() {
        fm.printAll();
    }

    private static void exception() {
        System.out.println("\nFailed to display data because it hasn't been loaded.\n");
    }

    private static void successfully() {
        System.out.println("\nSuccessfully loaded the data.\n");
        flag = true;
    }

    private static void exist() {
        System.out.println("\nCan't add more because data still exist.\nPlease restart the program and try again.\n");
    }

    private static String inputOriginAirport() {
        String name = "";
        while (true) {
            System.out.print("\nPlease enter origin airport: ");
            sc = new Scanner(System.in);
            name = sc.nextLine();
            if (name.equalsIgnoreCase(am.search(name))) {
                return name;
            }
        }
    }

    private static String inputDestinationAirport(String oriAirport) {
        String name = "";
        while (true) {
            System.out.print("\nPlease enter destination airport: ");
            sc = new Scanner(System.in);
            name = sc.nextLine();
            if (name.equalsIgnoreCase(fm.search(name, oriAirport))) {
                return name;
            }
        }
    }
}
