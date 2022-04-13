package com.solvd;

public interface IEngineStart {

    default void startEngine() {
        System.out.println("Engine started");
    }

    default void stopEngine() {
        System.out.println("Engine stopped");
    }
}
