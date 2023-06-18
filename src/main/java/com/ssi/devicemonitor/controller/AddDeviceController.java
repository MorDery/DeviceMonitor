package com.ssi.devicemonitor.controller;

import com.ssi.devicemonitor.entity.Device;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddDeviceController {

    public static Device display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);



        //Add the option of the device
        ToggleGroup typeToggle = new ToggleGroup();
        RadioButton general = new RadioButton ("General");
        RadioButton  hardware = new RadioButton ("Hardware");
        RadioButton  software = new RadioButton ("Software");
        general.setToggleGroup(typeToggle);
        hardware.setToggleGroup(typeToggle);
        software.setToggleGroup(typeToggle);
        //typeDeviceMenu.getItems().addAll(general, hardware, software);
    }


}
