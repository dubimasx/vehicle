package com.solvd.vehicle.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deadlock implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(Deadlock.class);
    FirstThread first = new FirstThread();
    SecondThread second = new SecondThread();

    public Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(Deadlock.this, "Competing thread");
        t.start();
        first.enterFirst(second);
        LOGGER.info("Back to main thread");
    }

    @Override
    public void run() {
        second.enterSecond(first);
        LOGGER.info("Back to competing thread");
    }


}
