/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import Lib.Car;

/**
 *
 * @author anyadanielle
 */
public class AutoCarFactory implements ICar{
    @Override
    public Car createCar(String plateNum, String brand, String model, String description, String transmission, double price) {
        double newPrice = additionalPrice() + price;
        return new Car(plateNum, brand, model, description, transmission, newPrice);
    }
    @Override
    public double additionalPrice(){
        return 500.00;
    }
}
