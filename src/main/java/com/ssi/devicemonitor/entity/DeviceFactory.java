package com.ssi.devicemonitor.entity;

import java.time.LocalDateTime;

public class DeviceFactory {
    public static Device createDevice(String name,String deviceType, String manufacturer, String version, String location, String macAddress, LocalDateTime installationDateTime) {
        if (deviceType.equalsIgnoreCase("Hardware")) {
            return new HardwareDevice(name, manufacturer, deviceType, version, location, macAddress);
        } else if (deviceType.equalsIgnoreCase("Software")) {
            return new SoftwareDevice(name,manufacturer, deviceType, version, installationDateTime);
        }else if (deviceType.equalsIgnoreCase("General")) {
            return new GeneralDevice(name);
        }
        return null;
    }
}
