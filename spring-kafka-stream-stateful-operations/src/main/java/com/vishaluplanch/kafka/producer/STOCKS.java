package com.vishaluplanch.kafka.producer;

public enum STOCKS {

    TATA_POWER_LTD(195.00, "TATA_POWER_LTD"),
    TCS(3450.00, "TCS"),
    INFOSYS(1000.00, "INFOSYS"),
    GOOGLE(12000.00, "GOOGLE"),
    TATA_MOTORS(471.00, "TATA_MOTORS"),
    TATA_CONSUMER(7500.00, "TATA_CONSUMER"),
    HCL(1100.00, "HCL"),
    MICROSOFT(3300.45, "MICROSOFT"),
    FORD(945.99, "FORD"),
    TECH_MAHINDRA(945.99, "TECH_MAHINDRA");

    Double price;
    String name;

    STOCKS(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
