package com.ssi.devicemonitor.controller;

import com.ssi.devicemonitor.entity.Device;
import com.ssi.devicemonitor.entity.DeviceMonitor;
import com.ssi.devicemonitor.entity.GeneralDevice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DeviceMonitorController {
    @FXML
    private ListView<Device> deviceListView;
    @FXML
    private TextField deviceNameTextField;
    @FXML
    private Button addDeviceButton;
    @FXML
    private Label deviceDetailListView;
    @FXML
    private Button hideDeviceDetailButton;
    private DeviceMonitor deviceMonitor;


    public void initialize() {
        deviceMonitor = new DeviceMonitor();

        deviceMonitor.addDevice(new GeneralDevice("Device 1"));
        deviceMonitor.addDevice(new GeneralDevice("Device 2"));
        deviceMonitor.addDevice(new GeneralDevice("Device 3"));

        deviceListView.setItems(FXCollections.observableList(deviceMonitor.getDevices()));
        deviceListView.setCellFactory(deviceListView -> new DeviceListCell());

        // Add context menu to ListView
        ContextMenu contextMenu = new ContextMenu();
        MenuItem removeItem = new MenuItem("Remove");
        MenuItem editItem = new MenuItem("Edit");
        contextMenu.getItems().addAll(removeItem,editItem);
        deviceListView.setContextMenu(contextMenu);

        removeItem.setOnAction(event -> {
            Device selectedDevice = deviceListView.getSelectionModel().getSelectedItem();
            if (selectedDevice != null) {
                deviceMonitor.removeDevice(selectedDevice);
                refreshListView();
            }
        });
        editItem.setOnAction(event -> {
            Device selectedDevice = deviceListView.getSelectionModel().getSelectedItem();
            if (selectedDevice != null) {
                //get the edit detail
                deviceMonitor.editDevice(selectedDevice, EditDeviceController.display(selectedDevice));
                refreshListView();
            }
        });

        addDeviceButton.setOnAction(event ->{
            deviceMonitor.addDevice(AddDeviceController.display());
            refreshListView();
        });

        deviceListView.setOnMouseClicked(mouseEvent -> {
            Device selectedDevice = deviceListView.getSelectionModel().getSelectedItem();
            if (selectedDevice != null) {
                deviceDetailListView.setText("Device Details:\n\n" +selectedDevice.toString());
            }
        });

        hideDeviceDetailButton.setOnAction(event ->{
            deviceDetailListView.setText("");
        });

    }

    private class DataUpdateTask extends TimerTask {
        private Random random = new Random();

        @Override
        public void run() {
            refreshListView();
        }
    }

    @FXML
    private void addDevice() {
        String deviceName = deviceNameTextField.getText();
        Device newDevice = new GeneralDevice(deviceName);
        deviceMonitor.addDevice(newDevice);
        deviceNameTextField.clear();
    }

    public void refreshListView() {
        deviceListView.refresh();
    }

    private class DeviceListCell extends ListCell<Device> {
        @Override
        protected void updateItem(Device device, boolean empty) {
            super.updateItem(device, empty);

            if (device == null || empty) {
                setText(null);
                setGraphic(null);
                setStyle(""); // Reset the cell style
            } else {
                setText(device.getName() + " - " + device.getStatus());

                // Set the cell style based on the device status
                if (device.getStatus().equals("Online")) {
                    setStyle("-fx-text-fill: green;");
                } else if (device.getStatus().equals("Offline")) {
                    setStyle("-fx-text-fill: red;");
                } else {
                    setStyle(""); // Reset the cell style
                }
            }
        }
    }
}
