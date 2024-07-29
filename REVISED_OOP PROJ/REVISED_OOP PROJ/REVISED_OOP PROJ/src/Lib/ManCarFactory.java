package Lib;

public class ManCarFactory implements ICar {

    @Override
    public Car createCar(String plateNum, String brand, String model, String description, String transmission, double price) {
        return new Car(plateNum, brand, model, description, transmission, price);
    }

    @Override
    public double additionalPrice() {
        return 0.00;
    }
}
