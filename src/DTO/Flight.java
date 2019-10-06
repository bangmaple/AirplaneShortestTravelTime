/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.AirportManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bangmaple
 */
public class Flight {

    private String airlineName;
    private String flight;
    private String originAirPort;
    private String departureTime;
    private String destinationAirport;
    private String arrivalTime;

    public Flight() {
    }

    public Flight(String airlineName, String flight, String originAirPort, String departureTime, String destinationAirport, String arrivalTime) {
        this.airlineName = airlineName;
        this.flight = flight;
        this.originAirPort = originAirPort;
        this.departureTime = departureTime;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getOriginAirPort() {
        return originAirPort;
    }

    public void setOriginAirPort(String originAirPort) {
        this.originAirPort = originAirPort;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void convertDepartureTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(AirportManager.getTimeZone(airlineName)));
    }

    public Date getNewDepartureTime() {
        DateFormat df = new SimpleDateFormat("h:mm a");
        Date h = null;
        System.out.println(departureTime);
        try {
            if (departureTime.length() == 5) {
                System.out.println(String.valueOf(departureTime.charAt(0))
                        + String.valueOf(departureTime.charAt(1)) + ":" + String.valueOf(departureTime.charAt(2))
                        + String.valueOf(departureTime.charAt(3)) + " " + String.valueOf(departureTime.charAt(4)) + "M");
                h = df.parse(departureTime.charAt(0)
                        + departureTime.charAt(1) + ":" + departureTime.charAt(2)
                        + departureTime.charAt(3) + " " + departureTime.charAt(4) + "M");
            } else if (departureTime.length() == 4) {
                System.out.println(departureTime.charAt(0)
                        + ":" + departureTime.charAt(1) + departureTime.charAt(2)
                        + " " + departureTime.charAt(3) + "M");
                h = df.parse(departureTime.charAt(0)
                        + ":" + departureTime.charAt(1) + departureTime.charAt(2)
                        + " " + departureTime.charAt(3) + "M");
            }
        } catch (ParseException ex) {
        }
        //System.out.println(String.valueOf(departureTime.charAt(departureTime.length()-1)).toLowerCase());

        //String hour = df.format(date);
        System.out.println("Hour: " + h);
//        if (departureTime.length() == 4) {
//
//            SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
//            System.out.println(departureTime.charAt(0) + departureTime.charAt(1));
//            System.out.println(departureTime.charAt(2) + departureTime.charAt(3));
//            String time = departureTime.substring(0, 1) + ":" + departureTime.substring(2, 3);
//            try {
//                date = sdf.parse(time);
//            } catch (Exception e) {
//                System.out.println("err");
//            }
//        }
        return h;
    }

    @Override
    public String toString() {
        return "[ " + airlineName + " - " + flight + " - " + originAirPort
                + " - " + departureTime + " - " + destinationAirport + " - " + arrivalTime + " ]";
    }

}
