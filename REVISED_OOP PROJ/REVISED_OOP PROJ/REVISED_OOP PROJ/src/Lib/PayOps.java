package Lib;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PayOps {
    private String filename = "PayRecord.txt";
    private static PayOps instance;
    public ArrayList<Payment> pay;

    private PayOps() {
        pay = new ArrayList<>();
    }

    public static PayOps getInstance(FleetInventory fi) {
        if (instance == null) {
            instance = new PayOps();
            instance.readFile(fi);
        }
        return instance;
    }

    public boolean recordTransac(Car car, String name, String phoneNum, String payMethod) {
        Payment p = new Payment(name, phoneNum, payMethod);
        p.setCar(car);
        pay.add(p);
        return true;
    }

    public ArrayList<PayRecord> generateReport() {
        var booking = new ArrayList<PayRecord>();
        for (Payment p : pay) {
            booking.add(new PayRecord(p));
        }
        return booking;
    }

    public boolean isAvailable(Car c) {
        if (c == null) {
            return false;
        }

        for (Payment p : pay) {
            Car transacCar = p.getCar();
            if (transacCar.equals(c)) {
                String transactionType = p.getPayMethod();
                if ("RENTED".equalsIgnoreCase(transactionType)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void readFile(FleetInventory fi) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));

            while (r.ready()) {
                String text = r.readLine();
                String[] line = text.split(",");
                try {
                    String plateNum = line[0];
                    String brand = line[1];
                    String model = line[2];
                    String description = line[3];
                    double price = Double.parseDouble(line[4]);
                    String transmission = line[5];
                    String name = line[6];
                    String phoneNum = line[7];
                    String payMethod = line[8];

                    Car c = new Car(plateNum, brand, model, description, transmission, price);
                    pay.add(new Payment(line[5], line[6], line[7]));

                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filename);
        }
    }

    public void writeFile() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder toWrite = new StringBuilder();
            for (Payment p : pay) {
                toWrite.append(p.getCar().toString()).append(",")
                        .append(p.getName()).append(",")
                        .append(p.getPhoneNum()).append(",")
                        .append(p.getPayMethod()).append("\n");
            }
            w.write(toWrite.toString());
            w.flush();
        } catch (IOException e) {
            System.out.println("Error saving.");
        }
    }
}
