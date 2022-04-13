package com.solvd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static Passenger[] showPassengers(Passenger[] pas) {
        for (Passenger i : pas) {
            if (i != null) {
                LOGGER.info(i.getName() + " ");
            }
        }
        return pas;
    }

    public static void main(String[] args) throws PassengerException, IOException {
        Station station = new Station("Molodejnaya");
        Station station2 = new Station();
        station2.setName("Frunzenskaya");
        Route route = new Route(station, station2, 10);
        Bus bus = new Bus("NewBus", 9, "Electric");
        bus.setRoute(route);
        LOGGER.info(route.getInitialStation().getName() + " " + route.getFinalStation().getName());
        Passenger pas1 = new Passenger("Slava");
        Passenger pas2 = new Passenger("Misha");
        Passenger pas3 = new Passenger("Stas");
        ArrayList<Passenger> passengers = new ArrayList<>();
        //Passenger[] passengers = new Passenger[bus.getCapacity()];
        bus.setPassengers(passengers);
        bus.addPassenger(pas1);
        bus.addPassenger(pas2);
        bus.addPassenger(pas3);
        bus.showInfo();
        //bus.showPassengers();
//        Taxi taxi = new Taxi("BMW", 3, 15);
//        taxi.calcPrice(route.getDistance());
//        Passenger[] taxiPassengers = new Passenger[taxi.getCapacity()];
//        //taxi.setPassengers(taxiPassengers);
//        taxi.showInfo();
//        Passenger oleg = new Passenger("Oleg");
//        bus.addPassenger(oleg);
//        bus.showPassengers(bus.getPassengers());
//        taxi.addPassenger(pas1);
//        taxi.showPassengers(taxi.getPassengers());
//        Station warehouse = new Station("Warehouse");
//        Station shop = new Station("Shop");
//        Route truckRoute = new Route(warehouse, shop, 15);
//        Passenger truckDriver = new Passenger("Michael");
//        Truck truck = new Truck("MAN", 2, "Products", 10);
//        Passenger[] truckDrivers = new Passenger[truck.getCapacity()];
//        truck.setPassengers(truckDrivers);
//        truck.addPassenger(truckDriver);
//        truck.addCargo(5);
//        truck.setRoute(truckRoute);
//        truck.showPassengers(truck.getPassengers());
//        truck.showInfo();
//        bus.showLimits();
//        truck.cargoShipped();
//        Bus.showBusCount();
//        //Passenger[] test = new Passenger[14];
//        //bus.setPassengers(test);
//        //truck.startEngine();
//        truck.startEngine();
//        truck.stopEngine();
//       // Truck testTruck = new Truck("TEST", 5, "People", 10);
//        //LOGGER.info("LOGGER INFO");
//       // LOGGER.error("LOGGER ERROR");
//        //LOGGER.debug("LOGGER DEBUG");
//        Truck testTruck = new Truck("TEST", 5, "TEST", 10);
//        LOGGER.info(testTruck.getPassengers());
//        LOGGER.info(testTruck.getCapacity());
        Bus testBus1 = new Bus("111", 2, "222");
        Bus testBus2 = new Bus("111", 2, "222");
        LOGGER.info(testBus2.equals(testBus1));
        BusDepot depot = new BusDepot();
        //ArrayList<Bus> busArrayList = new ArrayList<>();
        //busArrayList.add(testBus1);
        //depot.setBuses(busArrayList);
        //System.out.println(depot.isVehicleInDepot(testBus1));
        depot.setBus(testBus1);
        depot.setBus(testBus2);
        for (Bus i: depot.getBuses()) {
            LOGGER.info(i);
        }


        String content = FileUtils.readFileToString(new File("src/main/resources/text.txt"), StandardCharsets.UTF_8);
        String[] words = StringUtils.split(content, " ");
        Set<String> set = new HashSet<>();
        Arrays.stream(words).forEach(i -> set.add(i.replaceAll("\\W", "").toLowerCase()));
//        for (String i: words) {
//            set.add(i.replaceAll("\\W", "").toLowerCase());
//        }
//        set.forEach(i -> System.out.println(i));
//        set.forEach(System.out::println);
        for (String i: set) {
            FileUtils.writeStringToFile(new File("target/text2.txt"), i + " ", StandardCharsets.UTF_8, true);
        }
        LOGGER.info(set.size());


    }
}

