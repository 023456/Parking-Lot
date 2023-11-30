package org.example.Repositories;

import org.example.Models.ParkingFloor;
import org.example.Models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingFloorRepository {
    HashMap<Long, ParkingFloor> parkingFloorHashMap = new HashMap<>();
    Long prev_id =0L;


    public Optional<ParkingFloor> findById(Long id) {
        if (parkingFloorHashMap.containsKey(id)) {
            return Optional.of(parkingFloorHashMap.get(id));
        } else {
            return Optional.empty();
        }
    }
    public ParkingFloor save(ParkingFloor parkingFloor){
        prev_id = prev_id +1;
        parkingFloor.setId(prev_id);
        parkingFloorHashMap.put(prev_id,parkingFloor);
        return parkingFloor;
    }
}
