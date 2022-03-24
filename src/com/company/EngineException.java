package com.company;

public class EngineException extends Exception{
    public EngineException() {
    }

    public EngineException(String message) {
        super(message);
    }

    public EngineException(String message, Throwable cause) {
        super(message, cause);
    }

    public EngineException(Throwable cause) {
        super(cause);
    }

    public EngineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
