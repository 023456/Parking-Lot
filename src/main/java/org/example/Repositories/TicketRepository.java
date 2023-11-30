package org.example.Repositories;

import org.example.Models.Ticket;

import java.util.HashMap;
import java.util.Optional;

public class TicketRepository {
    HashMap<Long, Ticket> ticketHashMap = new HashMap<>();
    Long prev_id =0L;

    public Optional <Ticket> findById(Long id){
        if(ticketHashMap.containsKey(id)){
            return Optional.of(ticketHashMap.get(id));
        }
        return Optional.empty();
    }

    public Ticket  saveTicket(Ticket ticket){
        prev_id = prev_id +1;
        ticket.setId(prev_id);
        ticket.setNumber("Ticket - " + ticket.getId());
        ticketHashMap.put(prev_id,ticket);
        return ticket;
    }

}
