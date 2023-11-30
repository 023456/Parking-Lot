package org.example.Repositories;

import org.example.Models.Gate;
import org.example.Models.ParkingSlot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingSlotRepository {

    HashMap<Long, ParkingSlot> parkingSlotHashMap = new HashMap<>();
    Long prev_id =0L;
    String slot_id = "Slot_ID -"+0;



    public Optional<ParkingSlot> findById(Long id) {
        if (parkingSlotHashMap.containsKey(id)) {
            return Optional.of(parkingSlotHashMap.get(id));
        } else {
            return Optional.empty();
        }
    }
    public ParkingSlot save(ParkingSlot parkingSlot){
        prev_id = prev_id +1;
        parkingSlot.setId(prev_id);
        parkingSlot.setParkingSlotNumber("SLOT - " + parkingSlot.getId());
        parkingSlotHashMap.put(prev_id, parkingSlot);
        return parkingSlot;
    }

}
