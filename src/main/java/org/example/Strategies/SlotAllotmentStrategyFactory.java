package org.example.Strategies;

import org.example.Models.SlotAllotmentStrategyType;

public class SlotAllotmentStrategyFactory {
    public  static ParkingSlotAllocationStrategy getParkingSlotAllocationStrategy(SlotAllotmentStrategyType slotAllotmentStrategyType){
        if(slotAllotmentStrategyType==SlotAllotmentStrategyType.RANDOM){
            return new RandomParkingAllocationStrategy();
        }
        else if(slotAllotmentStrategyType ==SlotAllotmentStrategyType.NEAREST) {
            return  new NearestParkingAllocationStrategy();

        }
        return new RandomParkingAllocationStrategy();
    }
}
