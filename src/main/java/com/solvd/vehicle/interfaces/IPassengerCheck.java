package com.solvd.vehicle.interfaces;

import com.solvd.vehicle.Passenger;
import com.solvd.vehicle.Vehicle;

@FunctionalInterface
public interface IPassengerCheck<P extends Passenger, V extends Vehicle> {
    boolean isPassengerInVehicle(P p, V v);
}
