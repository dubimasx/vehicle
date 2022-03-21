package com.company;

public interface EngineStart {
    default void startEngine() {
        System.out.println("Engine started");
    }

    default void stopEngine() {
        System.out.println("Engine stopped");
    }
}
