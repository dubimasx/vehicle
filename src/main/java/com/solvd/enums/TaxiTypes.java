package com.solvd.enums;

public enum TaxiTypes {
    ECONOMY("Economy", 20.0), COMFORT("Comfort", 40.0), BUSINESS("Business", 60.0);
    final private String name;
    final private double price;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Type:'" + name + '\'' +
                ", Price:" + price;
    }

    TaxiTypes(String name, double price) {
        this.name = name;
        this.price = price;

    }
}


