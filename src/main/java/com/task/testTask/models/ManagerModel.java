package com.task.testTask.models;

import com.task.testTask.entities.Manager;

import javax.persistence.Column;

public class ManagerModel {

    private long id;

    private String fullName;

    private String phoneNumber;

    private String deputyFullName;

    private String DeputyPhoneNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeputyFullName() {
        return deputyFullName;
    }

    public void setDeputyFullName(String deputyFullName) {
        this.deputyFullName = deputyFullName;
    }

    public String getDeputyPhoneNumber() {
        return DeputyPhoneNumber;
    }

    public void setDeputyPhoneNumber(String deputyPhoneNumber) {
        DeputyPhoneNumber = deputyPhoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
