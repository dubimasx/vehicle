package com.solvd;

import java.util.ArrayList;

public class BusDepot extends Depot<Bus>{

    private ArrayList<Bus> buses = new ArrayList<Bus>();
    @Override
    public boolean isVehicleInDepot(Bus bus) {
        for (Bus i: buses) {
            if(i.equals(bus)){
                return true;
            }
        }
        return false;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    public void setBus(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }
}