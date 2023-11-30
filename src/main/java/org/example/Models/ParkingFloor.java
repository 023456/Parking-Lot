package org.example.Models;

import org.example.Repositories.ParkingLotRepository;
import org.example.Repositories.ParkingSlotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel {
    private int capacity;
    private int floorNo;
    private List<ParkingSlot> parkingSlots;

    private  FloorStatus floorStatus;
    private ParkingSlotRepository parkingSlotRepository;

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "capacity=" + capacity +
                ", parkingSlots=" + parkingSlots +
                ", floorStatus=" + floorStatus +
                ", parkingSlotRepository=" + parkingSlotRepository +
                "} " + super.toString();
    }

    public ParkingFloor(int capacity,ParkingSlotRepository parkingSlotRepository, int floorNo) {
        this.capacity = capacity;
        this.floorNo = floorNo;
        this.parkingSlots=new ArrayList<>();
        this.floorStatus = FloorStatus.VACANT;
        this.parkingSlotRepository = parkingSlotRepository;
        this.initialiseParkingSlots();

    }


    public void initialiseParkingSlots() {
      int fourWheelerCapacity =capacity/2;
      int twowheeler_capacity = capacity-fourWheelerCapacity;
        for(int i=0;i<fourWheelerCapacity;i++){
            ParkingSlot parkingSlot = new ParkingSlot(this, VehicleType.FOUR_WHEELER);
            parkingSlotRepository.save(parkingSlot);
            this.parkingSlots.add(parkingSlot);
        }
        for(int i=0;i<twowheeler_capacity;i++){
            ParkingSlot parkingSlot = new ParkingSlot(this, VehicleType.TWO_WHEELER);
            parkingSlotRepository.save(parkingSlot);
            this.parkingSlots.add(parkingSlot);
        }

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingSlot> getParkingSpots() {
        return parkingSlots;
    }

    public void setParkingSpots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }






    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}
