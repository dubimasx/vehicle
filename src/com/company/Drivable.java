package com.company;

public interface Drivable {
    default void drive() {
        System.out.println("Vehicle is driving");
    }
}
