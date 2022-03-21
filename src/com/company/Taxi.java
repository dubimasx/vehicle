package com.company;

public class Taxi extends Vehicle implements Drivable, EngineStart, Refillable, SpeedLimit {
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
        System.out.println("Model: " + super.getModel());
        System.out.println("Capacity: " + super.getCapacity());
        System.out.println("Price per kilometer " + getPricePerKilometer());
        if (finalPrice == 0)
            System.out.println("Ride did not end");
        else
            System.out.println("Ride price: " + finalPrice + " rub.");

    }


    @Override
    public void startEngine() {
        System.out.println("Taxi engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Taxi engine stopped");
    }

    @Override
    public void drive() {
        System.out.println("Taxi is driving");
    }

    @Override
    public void refuel() {
        System.out.println("Taxi has been refueled");
    }

    @Override
    public void showLimits() {
        System.out.println("Speed limit for cars is " + carLimit + " km/h");
    }
}
