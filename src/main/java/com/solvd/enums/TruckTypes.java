package com.solvd.enums;

public enum TruckTypes {
    LIGHTWEIGHT("Lightweight", 3), MEDUIMWEIGHT("Mediumweight", 5), HEAVYWEIGHT("Heavyweight", 7);

    final private String name;
    final private int weight;

    TruckTypes(String name, int weight) {
        this.name = name;
        this.weight = weight;

    }

    public int getWeight() {
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
