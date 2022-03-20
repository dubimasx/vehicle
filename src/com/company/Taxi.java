package com.company;

public class Taxi extends Vehicle {
    private int pricePerKilometer;
    private int finalPrice;
    public Taxi(String model, int capacity, int pricePerKilometer){
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
}
