package org.example.Strategies;

import org.example.Exception.ParkingSpotNotFound;
import org.example.Models.Gate;
import org.example.Models.ParkingLot;
import org.example.Models.ParkingSlot;
import org.example.Models.VehicleType;

public interface ParkingSlotAllocationStrategy {
    public ParkingSlot getSlot(ParkingLot parkingLot , VehicleType vehicleType) throws ParkingSpotNotFound;



}
