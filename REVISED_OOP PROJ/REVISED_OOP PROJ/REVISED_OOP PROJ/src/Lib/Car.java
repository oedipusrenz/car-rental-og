/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author ranip
 */
public class Car {
    private String plateNum;
    private String description;
    private String brand;
    private String model;
    private double price;
    private String transmission;
    

    public Car(String plateNum, String brand, String model, String description, String transmission, double price) {
        this.plateNum = plateNum;
        this.description = description;
        this.transmission = transmission;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
    
    public String geTrans(){
        return transmission;
    }
    
   
    
}
