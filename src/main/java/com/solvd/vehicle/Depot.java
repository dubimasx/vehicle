package com.solvd.vehicle;

abstract public class Depot<T extends Vehicle>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public boolean isVehicleInDepot(T vehicle);
}
