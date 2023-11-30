package org.example.Models;

public class ParkingSlot extends  BaseModel{
    private ParkingFloor parkingFloor;
    private VehicleType vehicleType;
    private ParkingSlotsStatus parkingSlotsStatus;
    private String parkingSlotNumber;

    public ParkingSlot(ParkingFloor parkingFloor,  VehicleType vehicleType) {
        this.parkingFloor = parkingFloor;
        this.vehicleType = vehicleType;
        this.parkingSlotsStatus =   ParkingSlotsStatus.VACANT;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotsStatus getParkingSpotsStatus() {
        return parkingSlotsStatus;
    }

    public void setParkingSpotsStatus(ParkingSlotsStatus parkingSlotsStatus) {
        this.parkingSlotsStatus = parkingSlotsStatus;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "vehicleType=" + vehicleType +
                ", parkingSlotsStatus=" + parkingSlotsStatus +
                "} " + super.toString();
    }

    public ParkingSlotsStatus getParkingSlotsStatus() {
        return parkingSlotsStatus;
    }

    public void setParkingSlotsStatus(ParkingSlotsStatus parkingSlotsStatus) {
        this.parkingSlotsStatus = parkingSlotsStatus;
    }

    public String getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(String parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
