package com.solvd.vehicle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Vehicle  {
    protected static final Logger LOGGER = LogManager.getLogger(Vehicle.class);
    private String model;
    private int capacity;
    private Route route;

    public Vehicle(String type, String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Vehicle(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Vehicle() {

    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public abstract void showInfo();

//    public void showPassengers() {
//        if (passengers != null) {
//            System.out.println("Passengers:");
//            for (Passenger i : passengers) {
//                if (i != null) {
//                    System.out.println(i.getName());
//                }
//            }
//        } else {
//            System.out.println("There is no passengers");
//        }
//    }





    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return capacity == vehicle.capacity && Objects.equals(model, vehicle.model) && Objects.equals(route, vehicle.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, capacity, route);
    }
}
