package com.company;

public class Truck extends Vehicle {
    private String cargoType;
    private int maxCargoCapacity;
    private int currentCargoCapacity;
    public Truck (String model, int capacity, String cargoType, int maxCargoCapacity){
        super(model, capacity);
        this.cargoType = cargoType;
        this.maxCargoCapacity = maxCargoCapacity;
    }

    public int getCurrentCargoCapacity() {
        return currentCargoCapacity;
    }

    public void setCurrentCargoCapacity(int currentCargoCapacity) {
        this.currentCargoCapacity = currentCargoCapacity;
    }


    public int getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public void setMaxCargoCapacity(int maxCargoCapacity) {
        this.maxCargoCapacity = maxCargoCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public void addCargo(int cargo){
        if(cargo != 0 && cargo >= 0)
            currentCargoCapacity += cargo;
    }


    @Override
    public void showPassengers(Passenger[] pas) {
        if (pas != null) {
            System.out.println("Drivers:");
            for (Passenger i : pas) {
                if (i != null) {
                    System.out.println(i.getName());
                }
            }
        } else {
            System.out.println("There is no drivers");
        }
    }
    @Override
    public void showInfo() {
        System.out.println("Model: " + super.getModel());
        System.out.println("Cargo type: " + getCargoType());
        System.out.println("Maximal capacity: " + getMaxCargoCapacity() + " t.");
        System.out.println("Current cargo capacity: " + getCurrentCargoCapacity() + " t.");

    }
}
