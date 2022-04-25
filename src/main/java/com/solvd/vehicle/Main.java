package com.solvd.vehicle;

import com.solvd.vehicle.deadlock.Deadlock;
import com.solvd.vehicle.enums.CargoTypes;
import com.solvd.vehicle.enums.TaxiTypes;
import com.solvd.vehicle.enums.TruckTypes;
import com.solvd.vehicle.exceptions.PassengerException;
import com.solvd.vehicle.interfaces.*;
import com.solvd.vehicle.service.FileService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {


        //Basic Tasks
        //basicHierarchyTasksRun();

        //Enum Task
        //enumTaskRun();

        //Deadlock Task
        //new Deadlock();

        //LinkedList Task
        //linkedListTaskRun();

        //Reflection Task
        //reflectionTaskRun();

        //Functional Interfaces Task
        //functionalInterfaceTaskRun();

        //FileUtils and StringUtils Task
        //FileService.writeUniqueWordsCountToFile("src/main/resources/text.txt", "target/text2.txt");

        //Stream Task
        //collectionStreamsTaskRun();


    }

    private static void basicHierarchyTasksRun() {
        Station station = new Station("Molodejnaya");
        Station station2 = new Station();
        station2.setName("Frunzenskaya");
        Route route = new Route(station, station2, 10);
        Bus bus = new Bus("NewBus", 9, "Electric");
        bus.setRoute(route);
        LOGGER.info(route.getInitialStation().getName() + " " + route.getFinalStation().getName());
        Passenger slava = new Passenger("Slava");
        Passenger misha = new Passenger("Misha");
        Passenger stas = new Passenger("Stas");
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            bus.setPassengers(passengers);
        } catch (PassengerException e) {
            LOGGER.error("Wrong number of passengers");
            throw new RuntimeException(e);
        }
        bus.addPassenger(slava);
        bus.addPassenger(misha);
        bus.addPassenger(stas);
        bus.showInfo();
    }

    private static void functionalInterfaceTaskRun() {

        Bus NewBus = new Bus("BasicBus", 2, "Electric");
        Passenger oleg = new Passenger("Oleg");
        Passenger slava = new Passenger("Slava");
        BusDepot busDepot = new BusDepot();
        busDepot.setName("Draznyia Depot");

        //IRegister
        IRegister<BusDepot, Bus> registration = (d, v) -> {
            d.setBus(v);
            return d;
        };

        registration.register(busDepot, NewBus);
        for (Bus i : busDepot.getBuses()) {
            LOGGER.info(i.toString());
        }

        //ILoad
        ILoad<Bus, Passenger> load = (b, p) -> {
            b.getPassengers().add(p);
            return b;
        };
        load.add(NewBus, oleg);
        load.add(NewBus, slava);
        LOGGER.info(NewBus.getPassengers().get(0).getName());
        LOGGER.info(NewBus.getPassengers().get(1).getName());

        //IPrint
        IPrint<Bus> printBus = (t) -> LOGGER.info(t.toString());
        printBus.print(NewBus);

        //IPassengerCheck
        IPassengerCheck<Passenger, Bus> check = (p, v) -> v.getPassengers().contains(p);
        LOGGER.info("Is passenger " +oleg.getName() + " in bus?: " + check.isPassengerInVehicle(oleg, NewBus));
        for (Passenger i : NewBus.getPassengers()) {
            LOGGER.info(i.getName());

        }

        //ICalculate
        ICalculate<Integer> calculate = Integer::sum;
        LOGGER.info("ICalculate: " + (calculate.calc(5, 3)));

    }

    private static void enumTaskRun() {
        Taxi taxi = new Taxi("TaskTaxi", 4, 20);
        taxi.setType(TaxiTypes.COMFORT);
        LOGGER.info(taxi.getType());
        Truck truck1 = new Truck("TaskTruck", 2, CargoTypes.FOOD, TruckTypes.LIGHTWEIGHT);
        LOGGER.info(truck1.getCargoType() + " " + truck1.getType());
    }

    private static void reflectionTaskRun() {
        try {
            Constructor defaultConstructor = null;
            for (Constructor constructor : Bus.class.getConstructors()) {
                if (constructor.getParameterCount() == 0) {
                    defaultConstructor = constructor;
                }
            }
            assert defaultConstructor != null;
            Bus reflectBus = (Bus) defaultConstructor.newInstance();
            Field[] fields = reflectBus.getClass().getDeclaredFields();
            LOGGER.info(fields[0].getName());
            LOGGER.info(reflectBus.getClass().getName());
            String varName = fields[0].getName();
            String fieldName = varName.substring(0, 1).toUpperCase() + varName.substring(1);
            Method m = reflectBus.getClass().getDeclaredMethod("get" + fieldName);
            Method k = reflectBus.getClass().getDeclaredMethod("set" + fieldName, fields[0].getType());
            k.invoke(reflectBus, "testEngine");
            String i = (String) m.invoke(reflectBus);
            LOGGER.info(i);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private static void linkedListTaskRun() {
        Taxi taskTaxi = new Taxi("Taxi Model", 2, 20);
        PassengerVIP vipPassenger = new PassengerVIP("John", "VIP");
        Passenger defaultPassenger = new Passenger("Jack");
        Passenger anotherDefaultPassenger = new Passenger("Joe");
        Passenger lastDefaultPassenger = new Passenger("Jill");
        taskTaxi.addPassenger(defaultPassenger);
        taskTaxi.addPassenger(anotherDefaultPassenger);
        taskTaxi.addPassenger(lastDefaultPassenger);
        taskTaxi.addPassenger(vipPassenger);
        LOGGER.info(taskTaxi.getPassengersQueue());
    }
    private static void collectionStreamsTaskRun() {
        Passenger james = new Passenger("James");
        Passenger michael = new Passenger("Michael");
        Passenger john = new Passenger("John");
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(james);
        passengers.add(michael);
        passengers.add(john);
        Stream<Passenger> stream = passengers.stream();
        stream.forEach(p -> LOGGER.info(p.getName()));

        Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
        randomNumbers.limit(20).forEach(LOGGER::info);

    }
}