package com.company;

public interface Shipping {
    default void cargoShipped() {
        System.out.println("Cargo was shipped");
    }
}
