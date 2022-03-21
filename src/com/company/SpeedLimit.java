package com.company;

public interface SpeedLimit {
    public static final int carLimit = 120;
    public static final int busLimit = 80;
    public static final int truckLimit = 80;

    default void showLimits(){
        System.out.println("Speed limit for cars is " + carLimit + " km/h");
        System.out.println("Speed limit for buses is " + busLimit + " km/h");
        System.out.println("Speed limit for trucks is " + truckLimit + " km/h");
    }


}
