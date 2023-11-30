package org.example.Controllers;

import org.example.Exception.GateException;
import org.example.Exception.InvalidTicket;
import org.example.Exception.ParkingSpotNotFound;
import org.example.Models.*;
import org.example.dtos.ResponseStatus;
import org.example.dtos.TicketRequestDto;
import org.example.dtos.TicketResponseDto;
import org.example.services.TicketService;

import java.time.LocalTime;

public class TicketController {
     private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public  TicketResponseDto issueTicket(TicketRequestDto ticketRequestDto) throws InvalidTicket, GateException, ParkingSpotNotFound {

      if (ticketRequestDto.getGateId() == 0 || ticketRequestDto.getVehicleNumber() == null ||
              ticketRequestDto.getVehicleType() == null) {
          throw new InvalidTicket("Ticket data is not valid");
      }


      return  ticketService.issueTicket(ticketRequestDto);
    }
}
