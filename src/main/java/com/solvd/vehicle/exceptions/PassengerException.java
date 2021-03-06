package com.solvd.vehicle.exceptions;

public class PassengerException extends Exception {
    public PassengerException() {
    }

    public PassengerException(String message) {
        super(message);
    }

    public PassengerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassengerException(Throwable cause) {
        super(cause);
    }

    public PassengerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
