package org.example.Models;

import org.example.Repositories.GateRepository;
import org.example.Repositories.OperatorRepository;

import java.util.Random;

public class Gate extends BaseModel {

    private GateType gateType;
    private  Operator operator;
    private OperatorRepository operatorRepository;

    @Override
    public String toString() {
        return "Gate{" +
                "gateType=" + gateType +
                ", operator=" + operator +
                ", operatorRepository=" + operatorRepository +
                "} " + super.toString();
    }

    public Gate(GateType gateType , OperatorRepository operatorRepository) {
        this.gateType = gateType;
        this.operatorRepository=operatorRepository;
        this.intialiseOperator();

    }

    public void intialiseOperator(){
      Operator operator1 = new Operator("Fatema");
      operatorRepository.save(operator1);
      this.operator = operator1;
  }
    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

}
