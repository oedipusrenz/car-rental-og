package Lib;

public interface ICar {

    Car createCar(String plateNum, String brand, String model, String description, String transmission, double price);
    double additionalPrice();
}
