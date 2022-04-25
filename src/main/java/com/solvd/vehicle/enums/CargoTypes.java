package com.solvd.vehicle.enums;

public enum CargoTypes {
    FOOD("Food"), WASTE("Waste"), MATERIALS("Materials");

    private String name;

    CargoTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CargoTypes{" +
                "name='" + name + '\'' +
                '}';
    }
}
