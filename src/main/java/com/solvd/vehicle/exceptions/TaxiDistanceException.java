package com.solvd.vehicle.exceptions;

public class TaxiDistanceException extends Exception {
    public TaxiDistanceException() {
    }

    public TaxiDistanceException(String message) {
        super(message);
    }

    public TaxiDistanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxiDistanceException(Throwable cause) {
        super(cause);
    }

    public TaxiDistanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
