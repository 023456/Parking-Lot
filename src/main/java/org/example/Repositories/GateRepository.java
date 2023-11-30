package org.example.Repositories;

import org.example.Models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    HashMap<Long, Gate> gateHashMap = new HashMap<Long, Gate>();
    Long prev_id =0L;

    public Optional<Gate> findById(Long id){
        if(gateHashMap.containsKey(id)){
            return Optional.of(gateHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    public Gate save(Gate gate){
        prev_id =prev_id + 1;
        gate.setId(prev_id);
        gateHashMap.put(prev_id,gate);
        return gate;
    }

}
