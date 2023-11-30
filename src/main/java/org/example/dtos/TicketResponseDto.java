package org.example.dtos;

import org.example.Models.Ticket;

import java.util.Date;
import java.util.HashMap;

public class TicketResponseDto {

    private String ticketNumber;
    private String VehicleNumber;
    private Date entryTime;

    private int floorNumber;
    private String slotNumber;



    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "TicketResponseDto{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", VehicleNumber='" + VehicleNumber + '\'' +
                ", entryTime=" + entryTime +
                ", floorNumber=" + floorNumber +
                ", slotNumber='" + slotNumber + '\'' +
                '}';
    }
}
