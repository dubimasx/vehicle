package com.company;

public interface Refillable {
    default void refuel() {
        System.out.println("Vehicle has been fueled");
    }

}
