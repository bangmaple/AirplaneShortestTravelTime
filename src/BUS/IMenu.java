/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.Scanner;

/**
 *
 * @author bangmaple
 */
public interface IMenu {

    static int Menu() {
        Scanner sc;
        int choice = 0;
        while (true) {
            System.out.println("========================================");
            System.out.println("[1] Load data (Airports and Flight).");
            System.out.println("[2] Calculate the shortest time travel.");
            System.out.println("[3] Display airport data.");
            System.out.println("[4] Display flight data.");
            System.out.println("[5] Exit.");
            System.out.println("========================================");
            try {
                System.out.print("Please choose: ");
                sc = new Scanner(System.in);
                choice = sc.nextInt();
            } catch (Exception e) {

            }
            if (choice > 0 && choice < 6) {
                break;
            }
        }
        return choice;
    }
}
