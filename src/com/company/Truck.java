package com.company;

public class Truck extends Vehicle implements Drivable, EngineStart, SpeedLimit, Refillable, Shipping {
    private String cargoType;
    private int maxCargoCapacity;
    private int currentCargoCapacity;

    public Truck(String model, int capacity, String cargoType, int maxCargoCapacity) {
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

    public void addCargo(int cargo) {
        if (cargo != 0 && cargo >= 0)
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

    @Override
    public void cargoShipped() {
        System.out.println("Cargo " + getCargoType() + " was shipped");
    }

    @Override
    public void startEngine() {
        System.out.println("Truck engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Truck engine stopped");
    }

    @Override
    public void drive() {
        System.out.println("Truck is driving");
    }

    @Override
    public void refuel() {
        System.out.println("Truck has been refueled");
    }

    @Override
    public void showLimits() {
        System.out.println("Speed limit for trucks is " + truckLimit + " km/h");
    }
}
