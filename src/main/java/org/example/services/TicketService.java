package org.example.services;

import org.example.Exception.GateException;
import org.example.Exception.ParkingSpotNotFound;
import org.example.Models.*;
import org.example.Repositories.GateRepository;
import org.example.Repositories.ParkingLotRepository;
import org.example.Repositories.TicketRepository;
import org.example.Repositories.VehicleRepository;
import org.example.Strategies.ParkingSlotAllocationStrategy;
import org.example.Strategies.SlotAllotmentStrategyFactory;
import org.example.dtos.TicketRequestDto;
import org.example.dtos.TicketResponseDto;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

public class TicketService {
      private VehicleRepository vehicleRepository;
      private GateRepository gateRepository;
      private ParkingLotRepository parkingLotRepository;
      private TicketRepository ticketRepository;

    public TicketService(VehicleRepository vehicleRepository, GateRepository gateRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }


    public TicketResponseDto issueTicket(TicketRequestDto ticketRequestDto) throws GateException, ParkingSpotNotFound {
      Ticket ticket = new Ticket();
      ticket.setEntrytime(new Date());
      String vehicleNumber = ticketRequestDto.getVehicleNumber();
      Optional<Vehicle> vehicleOptional= vehicleRepository.findByVehicleNumber(vehicleNumber);
      Vehicle vehicle;
      if(vehicleOptional.isPresent()){
          vehicle=vehicleOptional.get();
      }
      else {
          vehicle = new Vehicle(vehicleNumber,ticketRequestDto.getVehicleType());
          vehicle = vehicleRepository.save(vehicle);
      }
      ticket.setVehicle(vehicle);

      //gate
      Long gateId = ticketRequestDto.getGateId();
      Optional<Gate> gateOptional = gateRepository.findById(gateId);
      Gate gate;
      if(gateOptional.isEmpty()){
          throw new GateException("Gate not found");
      }
      gate = gateOptional.get();
      ticket.setGate(gate);

        ParkingLot parkingLot = parkingLotRepository.getParkingLotForGate(gate);
        SlotAllotmentStrategyType slotAllotmentStrategyType = parkingLot.getSlotAllotmentStrategyType();
        ParkingSlotAllocationStrategy parkingSlotAllocationStrategy = SlotAllotmentStrategyFactory.getParkingSlotAllocationStrategy(slotAllotmentStrategyType);
        ParkingSlot parkingSlot = parkingSlotAllocationStrategy.getSlot(parkingLot, ticketRequestDto.getVehicleType());
        ticket.setParkingSlot(parkingSlot);
        parkingSlot.setParkingSlotsStatus(ParkingSlotsStatus.FULL);
        ticket = ticketRepository.saveTicket(ticket);

        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setTicketNumber(ticket.getNumber());
        ticketResponseDto.setFloorNumber(parkingSlot.getParkingFloor().getFloorNo());
        ticketResponseDto.setSlotNumber(parkingSlot.getParkingSlotNumber());
        ticketResponseDto.setEntryTime(ticket.getEntrytime());
        ticketResponseDto.setVehicleNumber(vehicle.getVehicle_no());



        return ticketResponseDto;

    }


}
