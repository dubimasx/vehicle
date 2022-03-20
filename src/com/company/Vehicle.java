package com.company;

public abstract class Vehicle {
    private String model;
    private int capacity;
    private Route route;
    private Passenger[] passengers;

    public Vehicle(String type, String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Vehicle(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Vehicle() {

    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public abstract void showInfo();

    public void showPassengers(Passenger[] pas) {
        if (pas != null) {
            System.out.println("Passengers:");
            for (Passenger i : pas) {
                if (i != null) {
                    System.out.println(i.getName());
                }
            }
        } else {
            System.out.println("There is no passengers");
        }
    }

    public void addPassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                break;
            }
        }
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        if (capacity < passengers.length) {
            throw new RuntimeException("Too many passengers");
        }
        this.passengers = passengers;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
