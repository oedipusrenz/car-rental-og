package Lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentOps {

    private String filename = "rentals.txt";
    private static RentOps instance;
    public ArrayList<Rent> rent;

    public RentOps() {
        rent = new ArrayList<>();
    }

    public static RentOps getInstance(FleetInventory carInventory) {
        if (instance == null) {
            instance = new RentOps();
            instance.readFile(carInventory);
        }
        return instance;
    }

    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate lastDate) {
        if (car == null) {
            return false;
        }
        for (Rent r : rent) {
            if ((r.getCar().getPlateNum().equals(car.getPlateNum()))
                    && (startDate.isBefore(r.getLastDate()) && lastDate.isAfter(r.getStartDate()))) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<RentRecord> generateRecord() {
        ArrayList<RentRecord> newList = new ArrayList<>();
        for (Rent r : rent) {
            newList.add(new RentRecord(r));
        }
        return newList;
    }

    public boolean isAvailableNow(Car car) {
        if (car == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        for (Rent r : rent) {
            if ((r.getCar().getPlateNum().equals(car.getPlateNum()))
                    && ((now.isBefore(r.getLastDate()) || now.isEqual(r.getLastDate()))
                    && (now.isAfter(r.getStartDate()) || now.isEqual(r.getStartDate())))) {
                return false;
            }
        }
        return true;
    }

    public boolean RentCar(Car car, LocalDate startDate, LocalDate lastDate) {
        if (isCarAvailable(car, startDate, lastDate)) {
            Rent r = new Rent(car, startDate, lastDate);
            rent.add(r);
            writeFile();
            return true;
        }
        return false;
    }

    public boolean RemoveRental(Rent rental) {
        for (Rent r : rent) {
            if (r.getPlateNum().equals(rental.getPlateNum())) {
                rent.remove(r);
                writeFile();
                return true;
            }
        }
        return false;
    }

    public Rent getRentalByPlateNum(String plateNum) {
        for (Rent r : rent) {
            if (r.getPlateNum().equals(plateNum)) {
                return r;
            }
        }
        return null;
    }

    public int getTimesRented(Car car) {
        int times = 0;
        for (Rent r : rent) {
            if (r.getCar().getPlateNum().equals(car.getPlateNum())) {
                times++;
            }
        }
        return times;
    }

    public void readFile(FleetInventory f) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineComponents = line.split("###");
                Car car = f.getCarByPlateNum(lineComponents[2]);
                if (car != null) {
                    rent.add(new Rent(car,
                            LocalDate.parse(lineComponents[0]),
                            LocalDate.parse(lineComponents[1])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    public void writeFile() {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            StringBuilder toWrite = new StringBuilder();
            for (Rent r : rent) {
                toWrite.append(r.getStartDate().toString())
                        .append("###")
                        .append(r.getLastDate().toString())
                        .append("###")
                        .append(r.getCar().getPlateNum())
                        .append("\n");
            }
            fileWriter.write(toWrite.toString());
        } catch (IOException e) {
            System.out.println("An exception has occurred while saving to disk.");
        }
    }
}
