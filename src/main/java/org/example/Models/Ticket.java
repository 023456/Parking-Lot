package org.example.Models;

import javax.xml.crypto.Data;
import java.time.LocalTime;
import java.util.Date;

public class Ticket extends BaseModel{
    private String number;
    private Date entrytime;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;
   public Ticket(){

   }

    public Ticket(String number, Date entrytime, ParkingSlot parkingSlot, Vehicle vehicle, Gate gate, Operator operator) {
        this.number = number;
        this.entrytime = entrytime;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.gate = gate;
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public ParkingSlot getParkingSpot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number='" + number + '\'' +
                ", entrytime=" + entrytime +
                ", parkingSlot=" + parkingSlot +
                ", vehicle=" + vehicle +
                ", gate=" + gate +
                ", operator=" + operator +
                "} " + super.toString();
    }
}
