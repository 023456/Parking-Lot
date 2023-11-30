package org.example.Repositories;

import org.example.Models.Gate;
import org.example.Models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository {

    HashMap<Long, ParkingLot> parkingLotHashMap = new HashMap<>();
    Long prev_id =0L;


    public Optional<ParkingLot> findById(Long id) {
        if (parkingLotHashMap.containsKey(id)) {
            return Optional.of(parkingLotHashMap.get(id));
        } else {
            return Optional.empty();
        }
    }
    public ParkingLot save(ParkingLot parkingLot){
        prev_id = prev_id +1;
        parkingLot.setId(prev_id);
        parkingLotHashMap.put(prev_id,parkingLot);
        return parkingLot;
    }

    public ParkingLot getParkingLotForGate(Gate gate){
        for(ParkingLot parkingLot : parkingLotHashMap.values()){
           if(parkingLot.getEntryGate().equals(gate)){
               return parkingLot;
           }
        }
        return null;
    }
}
