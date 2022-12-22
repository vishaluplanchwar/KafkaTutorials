package com.vishaluplanch.org.vo;

import java.math.BigDecimal;

public class EmploymentDetail {

    private String employmentType;
    private String organizationName;
    private String position;
    private String location;
    private String address;
    private BigDecimal netSalary;
    private BigDecimal inHandSalary;


    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    public BigDecimal getInHandSalary() {
        return inHandSalary;
    }

    public void setInHandSalary(BigDecimal inHandSalary) {
        this.inHandSalary = inHandSalary;
    }
}
