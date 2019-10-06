/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author bangmaple
 */
public class Airport {

    private String airportName;
    private int timeZone;

    public Airport() {
    }

    public Airport(String airportName, int timeZone) {
        this.airportName = airportName;
        this.timeZone = timeZone;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    private String calcTimeZone() {
        return "GMT" + String.valueOf(timeZone / 100);
    }

    @Override
    public String toString() {
        return "[ " + airportName + " - " + calcTimeZone() +" ]";
    }

}
