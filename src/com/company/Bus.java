package com.company;

public class Bus extends Vehicle {
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
        System.out.println("Engine type: " + getEngineType());

    }
}
