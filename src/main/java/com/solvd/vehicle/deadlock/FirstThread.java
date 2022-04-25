package com.solvd.vehicle.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstThread {

    private static final Logger LOGGER = LogManager.getLogger(FirstThread.class);

    synchronized void enterFirst(SecondThread b) {

        String name = Thread.currentThread().getName();
        LOGGER.info(name + " entered method FirstThread.enterFirst()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Class FirstThread interrupted");
        }

        LOGGER.info(name + " will try to call SecondThread.last()");
        b.last();
    }

    synchronized void last() {
        LOGGER.info("In method FirstThread.last()");
    }
}
