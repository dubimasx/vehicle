package com.solvd;

public class PassengerVIP extends Passenger{
    private String status;
    public PassengerVIP(String name, String status) {
        super(name);
        this.status = status;
    }
}
