package com.vishaluplanch.org.vo;

public class ApplicantDetail {

    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private String currentAddress;
    private String permanentAddress;
    private EmploymentDetail employmentDetail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public EmploymentDetail getEmploymentDetail() {
        return employmentDetail;
    }

    public void setEmploymentDetail(EmploymentDetail employmentDetail) {
        this.employmentDetail = employmentDetail;
    }
}
