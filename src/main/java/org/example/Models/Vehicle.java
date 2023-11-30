package org.example.Models;

import java.time.LocalTime;

public class Vehicle extends BaseModel {

    private String vehicle_no;
    private String ownername;
    private VehicleType vehicleType;

    public Vehicle(String vehicle_no, VehicleType vehicleType) {
        this.vehicle_no = vehicle_no;
        this.vehicleType = vehicleType;
    }


    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_no='" + vehicle_no + '\'' +
                ", ownername='" + ownername + '\'' +
                ", vehicleType=" + vehicleType +
                "} " + super.toString();
    }
}
