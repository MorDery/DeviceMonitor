package com.ssi.devicemonitor.entity;

import java.time.LocalDateTime;

public class SoftwareDevice extends Device{
    private LocalDateTime installationDateTime;

    public SoftwareDevice(String name,String manufacturer, String deviceType, String version, LocalDateTime installationDateTime) {
        super(name,manufacturer, deviceType, version);
        this.installationDateTime = installationDateTime;
    }

    // Getters and setters for software-specific fields

    public LocalDateTime getInstallationDateTime() {
        return installationDateTime;
    }

    public void setInstallationDateTime(LocalDateTime installationDateTime) {
        this.installationDateTime = installationDateTime;
    }

    @Override
    public void displayDetails() {

    }
    @Override
    public String toString() {
        String details = "Name:" + getName() + "\n" + "Status:" + getStatus()+ "\n" + "Manufacturer:" + getManufacturer()+ "\n" + "DeviceType:" + getDeviceType()+ "\n" + "Version:" + getVersion()+ "\n" + "InstallationDateTime:" + getInstallationDateTime();
        return details;
    }
}
