package com.solvd.vehicle;

import com.solvd.vehicle.enums.TaxiTypes;
import com.solvd.vehicle.exceptions.TaxiDistanceException;
import com.solvd.vehicle.interfaces.Drivable;
import com.solvd.vehicle.interfaces.IEngineStart;
import com.solvd.vehicle.interfaces.Refillable;
import com.solvd.vehicle.interfaces.ISpeedLimit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Taxi<T extends Passenger> extends Vehicle implements Drivable, IEngineStart, Refillable, ISpeedLimit {
    private static final Logger LOGGER = LogManager.getLogger(Taxi.class);
    private double pricePerKilometer;
    private double finalPrice;
    private LinkedList<Passenger> passengersQueue = new LinkedList<>();

    private TaxiTypes type;


    public Taxi(String model, int capacity, int pricePerKilometer) {
        super(model, capacity);
        this.pricePerKilometer = pricePerKilometer;
    }

    public TaxiTypes getType() {
        return type;
    }

    public void setType(TaxiTypes type) {
        this.type = type;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }


    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public void setPricePerKilometer(double pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    public LinkedList<Passenger> getPassengersQueue() {
        return passengersQueue;
    }

    public void setPassengersQueue(LinkedList<Passenger> passengersQueue) {
        this.passengersQueue = passengersQueue;
    }

    public double calcPrice(double distance) {
        try {
            if (distance == 0) {
                throw new TaxiDistanceException("Distance is 0");
            } else {
                finalPrice = pricePerKilometer * distance;
            }
        } catch (TaxiDistanceException e) {
            LOGGER.error(e);
        }
        return finalPrice;
    }

    @Override
    public void showInfo() {
        LOGGER.info("Model: " + super.getModel());
        LOGGER.info("Capacity: " + super.getCapacity());
        LOGGER.info("Price per kilometer " + getPricePerKilometer());
        if (finalPrice == 0) LOGGER.info("Ride did not end");
        else LOGGER.info("Ride price: " + finalPrice + " rub.");

    }


    @Override
    public void startEngine() {
        LOGGER.info("Taxi engine started");
    }

    @Override
    public void stopEngine() {
        LOGGER.info("Taxi engine stopped");
    }

    @Override
    public void drive() {
        LOGGER.info("Taxi is driving");
    }

    @Override
    public void refuel() {
        LOGGER.info("Taxi has been refueled");
    }

    @Override
    public void showLimits() {
        LOGGER.info("Speed limit for cars is " + CAR_LIMIT + " km/h");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taxi)) return false;
        if (!super.equals(o)) return false;
        Taxi taxi = (Taxi) o;
        return pricePerKilometer == taxi.pricePerKilometer && finalPrice == taxi.finalPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pricePerKilometer, finalPrice);
    }

    public void addPassenger(Passenger pas){
        if(pas instanceof PassengerVIP){
            passengersQueue.addFirst(pas);
        }
        else {
            passengersQueue.addLast(pas);
        }

    }
}
