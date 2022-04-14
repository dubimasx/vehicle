package com.solvd.exceptions;

public class PassengerSpaceException extends Exception{
    public PassengerSpaceException() {
    }

    public PassengerSpaceException(String message) {
        super(message);
    }

    public PassengerSpaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassengerSpaceException(Throwable cause) {
        super(cause);
    }

    public PassengerSpaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
