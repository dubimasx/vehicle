package com.solvd.vehicle.interfaces;

import com.solvd.vehicle.Depot;
import com.solvd.vehicle.Vehicle;

@FunctionalInterface
public interface IRegister<D extends Depot, V extends Vehicle> {
    D register(D b, V p);
}
