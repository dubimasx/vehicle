package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Truck extends Vehicle implements Drivable, IEngineStart, SpeedLimit, Refillable, Shipping {
    private static final Logger LOGGER = LogManager.getLogger(Truck.class);
    private String cargoType;
    private int maxCargoCapacity;
    private int currentCargoCapacity;
    private boolean isActive;
    public static final int MAX_PASSENGER_SPACE = 2;

    public Truck(String model, int capacity, String cargoType, int maxCargoCapacity) {
        super(model, capacity);
        if (capacity > MAX_PASSENGER_SPACE) try {
            throw new PassengerSpaceException("Too many passengers");
        } catch (PassengerSpaceException e) {
            LOGGER.error("test",e);
        }
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
        if (cargo != 0 && cargo >= 0) currentCargoCapacity += cargo;
    }


//    @Override
//    public void showPassengers() {
//        if (super.getPassengers() != null) {
//            LOGGER.info("Drivers:");
//            for (Passenger i : super.getPassengers()) {
//                if (i != null) {
//                    LOGGER.info(i.getName());
//                }
//            }
//        } else {
//            LOGGER.info("There is no drivers");
//        }
//    }

    @Override
    public void showInfo() {
        LOGGER.info("Model: " + super.getModel());
        LOGGER.info("Cargo type: " + getCargoType());
        LOGGER.info("Maximal capacity: " + getMaxCargoCapacity() + " t.");
        LOGGER.info("Current cargo capacity: " + getCurrentCargoCapacity() + " t.");

    }

    @Override
    public void cargoShipped() {
        LOGGER.info("Cargo " + getCargoType() + " was shipped");
    }

    @Override
    public void startEngine() {
        try {
            if (isActive) throw new EngineException("Engine is active");
            LOGGER.info("Truck engine started");
            isActive = true;
        } catch (EngineException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void stopEngine() {
        LOGGER.info("Truck engine stopped");
        isActive = false;
    }

    @Override
    public void drive() {
        LOGGER.info("Truck is driving");
    }

    @Override
    public void refuel() {
        LOGGER.info("Truck has been refueled");
    }

    @Override
    public void showLimits() {
        LOGGER.info("Speed limit for trucks is " + truckLimit + " km/h");
    }
}
