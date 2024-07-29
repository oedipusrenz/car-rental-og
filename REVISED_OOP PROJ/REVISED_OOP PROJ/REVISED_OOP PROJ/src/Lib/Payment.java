package Lib;

import java.time.LocalDate;

public class Payment {
    private Car car;
    private Rent rent;
    private String name;
    private String phoneNum;
    private String payMethod;

    public Payment(String name, String phoneNum, String payMethod) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.payMethod = payMethod;
    }
    
    public double computePrice(){
        long day = rent.getDayCount();
        double total = day * 1000;
        return total;
    }
    
    public void setCar(Car car){
        this.car = car;
    }
    
    public Car getCar() {
        return car;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    
    public void setRent(Rent rent){
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
