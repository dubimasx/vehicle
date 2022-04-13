package com.solvd;

import java.util.List;

abstract public class Depot<T extends Vehicle>{
    private String name;
    abstract public boolean isVehicleInDepot(T vehicle);
}
