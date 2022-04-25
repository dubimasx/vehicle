package com.solvd.vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BusDepot extends Depot<Bus>{

    private Set<Bus> buses = new HashSet<Bus>();
    @Override
    public boolean isVehicleInDepot(Bus bus) {
        for (Bus i: buses) {
            if(i.equals(bus)){
                return true;
            }
        }
        return false;
    }

    public void setBuses(Set<Bus> buses) {
        this.buses = buses;
    }
    public void setBus(Bus bus) {
        buses.add(bus);
    }

    public Set<Bus> getBuses() {
        return buses;
    }
}