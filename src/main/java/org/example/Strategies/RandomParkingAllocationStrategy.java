package org.example.Strategies;

import org.example.Exception.ParkingSpotNotFound;
import org.example.Models.*;

import java.util.List;

public class RandomParkingAllocationStrategy implements ParkingSlotAllocationStrategy {
    @Override
    public ParkingSlot getSlot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingSpotNotFound {
       List<ParkingFloor> parkingFloorList =  parkingLot.getParkingfloors();

       for(int i=0;i<parkingFloorList.size();i++){
           List<ParkingSlot> parkingSlotList = parkingFloorList.get(i).getParkingSpots();
           for(int j=0;j<parkingSlotList.size();j++){
               ParkingSlot parkingSlot = parkingSlotList.get(j);
               if(parkingSlot.getParkingSpotsStatus()==ParkingSlotsStatus.VACANT && parkingSlot.getVehicleType().equals(vehicleType)){
                   return parkingSlot;
               }
           }
       }
      throw new ParkingSpotNotFound("No parking spot available for this vehicle type" + vehicleType.name());
    }
}
