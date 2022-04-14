package com.solvd;

import com.solvd.enums.TaxiTypes;
import com.solvd.interfaces.Drivable;
import com.solvd.interfaces.IEngineStart;
import com.solvd.interfaces.Refillable;
import com.solvd.interfaces.SpeedLimit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Objects;

public class Taxi extends Vehicle implements Drivable, IEngineStart, Refillable, SpeedLimit {
    private static final Logger LOGGER = LogManager.getLogger(Taxi.class);
    private int pricePerKilometer;
    private int finalPrice;

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

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }


    public int getPricePerKilometer() {
        return pricePerKilometer;
    }

    public void setPricePerKilometer(int pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    public int calcPrice(int distance) {
        if (distance != 0) finalPrice = pricePerKilometer * distance;
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
        LOGGER.info("Speed limit for cars is " + carLimit + " km/h");
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
}
