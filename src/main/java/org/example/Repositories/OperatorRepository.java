package org.example.Repositories;


import org.example.Models.Operator;

import java.util.HashMap;
import java.util.Optional;

public class OperatorRepository {
    HashMap<Long, Operator> OpeartorHashMap = new HashMap<Long, Operator>();
    Long prev_id =0L;


    public Optional<Operator> findById(Long id){
        if(OpeartorHashMap.containsKey(id)){
            return Optional.of(OpeartorHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    public Operator save(Operator operator){
        prev_id =prev_id + 1;
        operator.setEmp_id("EmpId -"+prev_id);
        operator.setId(prev_id);
        OpeartorHashMap.put(prev_id,operator);
        return operator;
    }
}
