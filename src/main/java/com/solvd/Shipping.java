package com.solvd;

public interface Shipping {
    default void cargoShipped() {
        System.out.println("Cargo was shipped");
    }
}
