package com.solvd.vehicle;

import java.util.Objects;

public class PassengerVIP extends Passenger{
    private String status;
    public PassengerVIP(String name, String status) {
        super(name);
        this.status = status;
    }

    public PassengerVIP() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerVIP)) return false;
        PassengerVIP that = (PassengerVIP) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
