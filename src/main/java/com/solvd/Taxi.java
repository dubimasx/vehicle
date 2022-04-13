package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Taxi extends Vehicle implements Drivable, IEngineStart, Refillable, SpeedLimit {
    private static final Logger LOGGER = LogManager.getLogger(Taxi.class);
    private int pricePerKilometer;
    private int finalPrice;

    public Taxi(String model, int capacity, int pricePerKilometer) {
        super(model, capacity);
        this.pricePerKilometer = pricePerKilometer;
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
        if (distance != 0)
            finalPrice = pricePerKilometer * distance;
        return finalPrice;
    }

    @Override
    public void showInfo() {
        LOGGER.info("Model: " + super.getModel());
        LOGGER.info("Capacity: " + super.getCapacity());
        LOGGER.info("Price per kilometer " + getPricePerKilometer());
        if (finalPrice == 0)
            LOGGER.info("Ride did not end");
        else
            LOGGER.info("Ride price: " + finalPrice + " rub.");

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
}
