package org.example;

import org.example.Controllers.TicketController;
import org.example.Exception.GateException;
import org.example.Exception.InvalidTicket;
import org.example.Exception.ParkingSpotNotFound;
import org.example.Models.*;
import org.example.Repositories.*;
import org.example.dtos.TicketRequestDto;
import org.example.dtos.TicketResponseDto;
import org.example.services.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws GateException, ParkingSpotNotFound, InvalidTicket {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLot parkingLot = new ParkingLot("ParkingLot" , SlotAllotmentStrategyType.RANDOM,
                new ParkingFloorRepository() ,gateRepository,new ParkingSlotRepository() ,new OperatorRepository()
                );
//        System.out.println(parkingLot);
        parkingLotRepository.save(parkingLot);
        Operator operatorName = new Operator("Fatema");

        TicketRequestDto ticketRequestDto = new TicketRequestDto();
        ticketRequestDto.setGateId(1L);
        ticketRequestDto.setOperator(operatorName);
        ticketRequestDto.setVehicleNumber("KA-12567");
        ticketRequestDto.setVehicleType(VehicleType.FOUR_WHEELER);
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService(vehicleRepository,gateRepository,
                parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        TicketResponseDto ticketResponseDto = ticketController.issueTicket(ticketRequestDto);
        TicketResponseDto ticketResponseDto1 = ticketController.issueTicket(ticketRequestDto);
        System.out.println(ticketResponseDto);
        System.out.println(ticketResponseDto1);
    }
}