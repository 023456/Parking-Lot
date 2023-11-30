package org.example.Models;

import org.example.Repositories.GateRepository;
import org.example.Repositories.OperatorRepository;
import org.example.Repositories.ParkingFloorRepository;
import org.example.Repositories.ParkingSlotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingfloors;
    private Gate entryGate;
    private Gate exitGate;
    private  ParkingLotStatus parkingLotStatus;
    private SlotAllotmentStrategyType slotAllotmentStrategyType;
    private String name;
    private ParkingFloorRepository parkingFloorRepository;
    private GateRepository gateRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private OperatorRepository operatorRepository;

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingfloors=" + parkingfloors +
                ", entryGate=" + entryGate +
                ", exitGate=" + exitGate +
                ", parkingLotStatus=" + parkingLotStatus +
                ", slotAllotmentStrategyType=" + slotAllotmentStrategyType +
                ", name='" + name + '\'' +
                ", parkingFloorRepository=" + parkingFloorRepository +
                ", gateRepository=" + gateRepository +
                "} " + super.toString();
    }

    public ParkingLot(String name , SlotAllotmentStrategyType slotAllotmentStrategyType ,
                      ParkingFloorRepository parkingFloorRepository,GateRepository gateRepository ,
                      ParkingSlotRepository parkingSlotRepository , OperatorRepository operatorRepository ) {
        this.name = name;
        this.slotAllotmentStrategyType = slotAllotmentStrategyType;
        this.parkingfloors = new ArrayList<>();
        this.parkingLotStatus = ParkingLotStatus.OPEN;
        this.parkingFloorRepository = parkingFloorRepository;
        this.gateRepository = gateRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.operatorRepository = operatorRepository;
        this.intialiseFloors();
        this.intialiseEntryGate();
        this.initialiseExitGate();

    }

    public void intialiseFloors(){
        for(int i=0;i<3;i++){
            ParkingFloor parkingFloor = new ParkingFloor(60,parkingSlotRepository, i+1);
           parkingFloorRepository.save(parkingFloor);
           this.parkingfloors.add(parkingFloor);
        }
    }

    public void intialiseEntryGate(){
        Gate gate = new Gate(GateType.ENTRY , operatorRepository);
        gateRepository.save(gate);
        this.entryGate = gate;
    }

    public void initialiseExitGate(){
        Gate gate = new Gate(GateType.EXIT,operatorRepository);
        gateRepository.save(gate);
        this.exitGate = gate;
    }

    public List<ParkingFloor> getParkingfloors() {
        return parkingfloors;
    }

    public void setParkingfloors(List<ParkingFloor> parkingfloors) {
        this.parkingfloors = parkingfloors;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SlotAllotmentStrategyType getSlotAllotmentStrategyType() {
        return slotAllotmentStrategyType;
    }

    public void setSlotAllotmentStrategyType(SlotAllotmentStrategyType slotAllotmentStrategyType) {
        this.slotAllotmentStrategyType = slotAllotmentStrategyType;
    }
}
