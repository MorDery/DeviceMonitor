package com.ssi.devicemonitor.entity;

public class HardwareDevice extends Device {
    private String location;
    private String macAddress;

    public HardwareDevice(String name,String manufacturer, String deviceType, String version, String location, String macAddress) {
        super(name,manufacturer, deviceType, version);
        this.location = location;
        this.macAddress = macAddress;
    }

    // Getters and setters for hardware-specific fields

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public void displayDetails() {

    }

    @Override
    public String toString() {
        String details = "Name:" + getName() + "\n" + "Status:" + getStatus()+ "\n" + "Manufacturer:" + getManufacturer()+ "\n" + "DeviceType:" + getDeviceType()+ "\n" + "Version:" + getVersion()+ "\n" + "Location:" + getLocation()+ "\n" + "MacAddress:" + getMacAddress() ;
        return details;
    }
}
