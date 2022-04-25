package com.solvd.vehicle.interfaces;

import com.solvd.vehicle.Passenger;
import com.solvd.vehicle.Vehicle;

@FunctionalInterface
public interface ILoad<B extends Vehicle, P extends Passenger> {
    B add(B b, P p);
}
