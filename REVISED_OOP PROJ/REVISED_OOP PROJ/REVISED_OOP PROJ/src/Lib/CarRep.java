/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

/**
 *
 * @author ranip
 */
public class CarRep {
    private final Car car;
    private final boolean isAvail;
  
    public CarRep(Car car, boolean isAvail) {
        this.car = car;
        this.isAvail = isAvail;
    }
  
    public Car getCar() {
        return this.car;
    }
  
    public boolean isAvailable() {
        return this.isAvail;
    }

  
}
