package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bus extends Vehicle implements IEngineStart, Drivable, Refillable, SpeedLimit {
    private String engineType;
    public static final int MAX_NUMBER_OF_BUSES = 100;
    private static int busCount;
    private List<Passenger> passengers;

    static {
        LOGGER.info("Hello, I am static initializer");
    }

    public static int getBusCount() {
        return busCount;
    }

    public static void setBusCount(int busCount) {
        Bus.busCount = busCount;
    }


    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Bus(String model, int capacity, String engineType) {
        super(model, capacity);
        this.engineType = engineType;
        busCount++;
    }

    public static void showBusCount() {
        LOGGER.info("Maximal number of buses: " + MAX_NUMBER_OF_BUSES);
        LOGGER.info("Current number of buses: " + getBusCount());
    }

    @Override
    public void showInfo() {
        LOGGER.info("Model: " + super.getModel());
        LOGGER.info("Capacity: " + super.getCapacity());
        LOGGER.info("Engine type: " + this.getEngineType());

    }

    @Override
    public String toString() {
        String s = "Model: " + super.getModel() + "\n" + "Capacity: " + super.getCapacity() + "\n" + "Engine type " + getEngineType();

        return s;
    }

    @Override
    public void startEngine() {
        LOGGER.info("Bus " + getEngineType() + " engine started");
    }

    @Override
    public void stopEngine() {
        LOGGER.info("Bus " + getEngineType() + " engine stopped");
    }

    @Override
    public void drive() {
        LOGGER.info("Bus is driving");
    }

    @Override
    public void refuel() {
        LOGGER.info("Bus has been refueled");
    }

    @Override
    public void showLimits() {
        LOGGER.info("Speed limit for buses is " + busLimit + " km/h");
    }

    public final void addPassenger(Passenger passenger) {
        try {
            if (passenger == null) {
                throw new PassengerException("Passenger is null");
            } else {

                passengers.add(passenger);
            }
        } catch (PassengerException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) throws PassengerException {
        if (super.getCapacity() < passengers.size()) {
            throw new PassengerException("Too many passengers");
        }
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return Objects.equals(engineType, bus.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineType);
    }
}
