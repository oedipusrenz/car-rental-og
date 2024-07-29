/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ranip
 */
public class FleetInventory {
    private final String filename = "cars.txt";
    private static FleetInventory instance;
    private final ArrayList<Car> fleet;

    public ArrayList<Car> getFleet() {
        return fleet;
    }

    
    private FleetInventory() {
        fleet = new ArrayList<>();
    }

   ////SINGLETON
    public static FleetInventory getInstance() {
        if (instance == null) {
            instance = new FleetInventory();
            instance.readFile();
        }
        return instance;
    }

  
    public boolean AddCar(Car car) {
        for (Car c : fleet) {
            if (c.getPlateNum() == null ? car.getPlateNum() == null : c.getPlateNum().equals(car.getPlateNum())) {
                writeFile();
                return false;
            }
        }
        fleet.add(car);
        return true;
    }

   
    public boolean RemoveCar(Car car) {
        for (Car c : fleet) {
            if (c.getPlateNum() == null ? car.getPlateNum() == null : c.getPlateNum().equals(car.getPlateNum())) {
                fleet.remove(c);
                writeFile();
                return true;
            }
        }
        return false;
    }

    
    public Car getCarByPlateNum(String plateNum) {
        for (Car car : fleet) {
            if (car.getPlateNum() == null ? plateNum == null : car.getPlateNum().equals(plateNum)) {
                return car;
            }
        }
        return null;
    }

    
    public ArrayList<CarRep> generateReport(RentOps ro) {
        var reps = new ArrayList<CarRep>();
        for (Car c : fleet) {
            var report = new CarRep(c, ro.isAvailableNow(c));
            reps.add(report);
        }
        return reps;
    }

    
    public void readFile() {
        try (BufferedReader r = new BufferedReader(new FileReader(filename))) {
            while (r.ready()) {
                String text = r.readLine();
                String[] lineComponents = text.split("###");
                fleet.add(
                        new Car(
                                lineComponents[0],//id
                                lineComponents[1],//brand
                                lineComponents[2],//model
                                lineComponents[3],//description
                                lineComponents[4],//transmission
                                Double.parseDouble(lineComponents[5])//price
                        ));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    
    public void writeFile() {
        try (FileWriter fw = new FileWriter(filename)) {
            StringBuilder write = new StringBuilder();
            for (Car c : fleet) {
                write.append(c.getPlateNum()).append("###")
                        .append(c.getBrand()).append("###")
                        .append(c.getModel()).append("###")
                        .append(c.getDescription()).append("###")
                        .append(c.geTrans()).append("###")
                        .append(c.getPrice()).append("\n");
            }
            fw.write(write.toString());
            fw.flush();
        } catch (IOException e) {
            System.out.println("An exception has occurred while saving to disk.");
        }
    }
}

