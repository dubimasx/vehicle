package com.company;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static Passenger[] showPassengers(Passenger[] pas) {
        for (Passenger i : pas) {
            if (i != null) {
                System.out.print(i.getName() + " ");
            }
        }
        return pas;
    }

    public static void main(String[] args) throws PassengerException {
        Station station = new Station("Molodejnaya");
        Station station2 = new Station();
        station2.setName("Frunzenskaya");
        Route route = new Route(station, station2, 10);
        Bus bus = new Bus("NewBus", 9, "Electric");
        bus.setRoute(route);
        System.out.println(route.getInitialStation().getName() + " " + route.getFinalStation().getName());
        Passenger pas1 = new Passenger("Slava");
        Passenger pas2 = new Passenger("Misha");
        Passenger pas3 = new Passenger("Stas");
        Passenger[] passengers = new Passenger[bus.getCapacity()];
        bus.setPassengers(passengers);
        bus.addPassenger(pas1);
        bus.addPassenger(pas2);
        bus.addPassenger(pas3);
        bus.showInfo();
        Taxi taxi = new Taxi("BMW", 3, 15);
        taxi.calcPrice(route.getDistance());
        Passenger[] taxiPassengers = new Passenger[taxi.getCapacity()];
        taxi.setPassengers(taxiPassengers);
        taxi.showInfo();
        Passenger oleg = new Passenger("Oleg");
        bus.addPassenger(oleg);
        bus.showPassengers(bus.getPassengers());
        taxi.addPassenger(pas1);
        taxi.showPassengers(taxi.getPassengers());
        Station warehouse = new Station("Warehouse");
        Station shop = new Station("Shop");
        Route truckRoute = new Route(warehouse, shop, 15);
        Passenger truckDriver = new Passenger("Michael");
        Truck truck = new Truck("MAN", 2, "Products", 10);
        Passenger[] truckDrivers = new Passenger[truck.getCapacity()];
        truck.setPassengers(truckDrivers);
        truck.addPassenger(truckDriver);
        truck.addCargo(5);
        truck.setRoute(truckRoute);
        truck.showPassengers(truck.getPassengers());
        truck.showInfo();
        bus.showLimits();
        truck.cargoShipped();
        Bus.showBusCount();
        //Passenger[] test = new Passenger[14];
        //bus.setPassengers(test);
        //truck.startEngine();
        truck.startEngine();
        truck.stopEngine();
       // Truck testTruck = new Truck("TEST", 5, "People", 10);
        //LOGGER.info("LOGGER INFO");
       // LOGGER.error("LOGGER ERROR");
        //LOGGER.debug("LOGGER DEBUG");
        Truck testTruck = new Truck("TEST", 5, "TEST", 10);
        LOGGER.info(testTruck.getPassengers());
        LOGGER.info(testTruck.getCapacity());






    }
}

