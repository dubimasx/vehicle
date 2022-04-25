package com.solvd.vehicle.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondThread {

    private static final Logger LOGGER = LogManager.getLogger(SecondThread.class);

    synchronized void enterSecond(FirstThread a) {

        String name = Thread.currentThread().getName();
        LOGGER.info(name + " entered method SecondThread.enterSecond()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("class SecondThread interrupted");
        }

        LOGGER.info(name + " will try to call FirstThread.last()");
        a.last();
    }

    synchronized void last() {
        LOGGER.info("In method SecondThread.last()");
    }
}
