package com.solvd.vehicle;

import com.solvd.vehicle.enums.CargoTypes;
import com.solvd.vehicle.enums.TruckTypes;
import com.solvd.vehicle.exceptions.EngineException;
import com.solvd.vehicle.exceptions.PassengerSpaceException;
import com.solvd.vehicle.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class Truck extends Vehicle implements Drivable, IEngineStart, ISpeedLimit, Refillable, IShipping {
    private static final Logger LOGGER = LogManager.getLogger(Truck.class);
    private CargoTypes cargoType;
    private TruckTypes type;
    private int currentCargoCapacity;
    private boolean isActive;
    public static final int MAX_PASSENGER_SPACE = 2;

    public Truck(String model, int capacity, CargoTypes cargoType, TruckTypes type) {
        super(model, capacity);
        if (capacity > MAX_PASSENGER_SPACE) try {
            throw new PassengerSpaceException("Too many passengers");
        } catch (PassengerSpaceException e) {
            LOGGER.error("test",e);
        }
        this.type = type;
        this.cargoType = cargoType;
    }

    public Truck() {};

    public int getCurrentCargoCapacity() {
        return currentCargoCapacity;
    }

    public void setCurrentCargoCapacity(int currentCargoCapacity) {
        this.currentCargoCapacity = currentCargoCapacity;
    }

    public CargoTypes getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoTypes cargoType) {
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
        LOGGER.info("Speed limit for trucks is " + TRUCK_LIMIT + " km/h");
    }

    public TruckTypes getType() {
        return type;
    }

    public void setType(TruckTypes type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return currentCargoCapacity == truck.currentCargoCapacity && isActive == truck.isActive && Objects.equals(cargoType, truck.cargoType) && type == truck.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoType, type, currentCargoCapacity, isActive);
    }
}
