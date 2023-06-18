package com.ssi.devicemonitor.entity;

public class GeneralDevice extends Device {
    public GeneralDevice(String name) {
        super(name);
    }

    @Override
    public void displayDetails() {

    }
    @Override
    public String toString() {
        String details = "Name:" + getName() + "\n" + "Status:" + getStatus();
        return details;
    }
}
