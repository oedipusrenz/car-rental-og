package Lib;

public class PayRecord {
    private Car car;
    private String name;
    private String phoneNum;
    private String payMethod;
    private Payment p;

    public PayRecord(Payment p) {
        this.car = p.getCar();
        this.name = p.getName();
        this.phoneNum = p.getPhoneNum();
        this.payMethod = p.getPayMethod();
        this.p = p;
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public Payment getP() {
        return p;
    }
}
