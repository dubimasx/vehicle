package com.solvd.vehicle.enums;

public enum TruckTypes {
    LIGHTWEIGHT("Lightweight", WeightTypes.LIGHT), MEDUIMWEIGHT("Mediumweight", WeightTypes.MEDIUM), HEAVYWEIGHT("Heavyweight", WeightTypes.HEAVY);

    final private String name;
    final private WeightTypes weight;


    TruckTypes(String name, WeightTypes weight) {
        this.name = name;
        this.weight = weight;
    }

    public WeightTypes getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TruckTypes{" +
                "Type='" + name + '\'' +
                ", Max weight=" + weight +
                '}';
    }
}
