package org.example.Repositories;

import org.example.Models.Vehicle;
import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    HashMap<Long, Vehicle> vehicleHashMap = new HashMap<>();
    HashMap<String, Vehicle> vehicleNumberHashMap = new HashMap<>();
    Long prev_id = 0L;
    public Optional<Vehicle> findById(Long id){
        if(vehicleHashMap.containsKey(id)){
            return Optional.of(vehicleHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    public Vehicle save(Vehicle vehicle){
        prev_id = prev_id+1;
        vehicle.setId(prev_id);
        vehicleHashMap.put(prev_id,vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber){
        if(vehicleNumberHashMap.containsKey(vehicleNumber)){
            return Optional.of(vehicleNumberHashMap.get(vehicleNumber));
        }
        else {
            return Optional.empty();
        }
    }
}
