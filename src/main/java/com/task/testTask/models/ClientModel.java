package com.task.testTask.models;

public class ClientModel {

    private String clientCode;


    private String fullName;


    private String address;

    private String managerFullName;

    private String managerPhoneNumber;

    private String managerDeputyPhoneNumber;


    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagerFullName() {
        return managerFullName;
    }

    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public String getManagerDeputyPhoneNumber() {
        return managerDeputyPhoneNumber;
    }

    public void setManagerDeputyPhoneNumber(String managerDeputyPhoneNumber) {
        this.managerDeputyPhoneNumber = managerDeputyPhoneNumber;
    }
}
