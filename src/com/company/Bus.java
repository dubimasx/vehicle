package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Bus extends Vehicle implements EngineStart, Drivable, Refillable, SpeedLimit {
    private String engineType;

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Bus(String model, int capacity, String engineType) {
        super(model, capacity);
        this.engineType = engineType;
    }

    @Override
    public void showInfo() {
        System.out.println("Model: " + super.getModel());
        System.out.println("Capacity: " + super.getCapacity());
        System.out.println("Engine type: " + this.getEngineType());

    }

    @Override
    public String toString() {
        String s = "Model: " + super.getModel() + "\n" +
                "Capacity: " + super.getCapacity() + "\n" +
                "Engine type " + getEngineType();

        return s;
    }

    @Override
    public boolean equals(Object o) {
        Bus bus = (Bus) o;
        if (bus.getModel() == super.getModel() && bus.getCapacity() == super.getCapacity() && bus.getRoute() == super.getRoute() && bus.getEngineType() == this.getEngineType()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.getModel(), super.getCapacity(), super.getRoute(), this.getEngineType());
        return result;
    }

    @Override
    public void startEngine() {
        System.out.println("Bus " + getEngineType() + " engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Bus " + getEngineType() + " engine stopped");
    }

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }

    @Override
    public void refuel() {
        System.out.println("Bus has been refueled");
    }

    @Override
    public void showLimits() {
        System.out.println("Speed limit for buses is " + busLimit + " km/h");
    }
}
