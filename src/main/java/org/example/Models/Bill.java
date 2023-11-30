package org.example.Models;

import java.time.LocalTime;
import java.util.List;

public class Bill extends BaseModel {

    private LocalTime exit_time;
    private Ticket ticketno;
    private int amount;
    private List<Payment> payment;
    private Gate gate;


    public Bill(LocalTime exit_time, Ticket ticketno, int amount, List<Payment> payment, Gate gate) {

        this.exit_time = exit_time;
        this.ticketno = ticketno;
        this.amount = amount;
        this.payment = payment;
        this.gate = gate;
    }

    public LocalTime getExit_time() {
        return exit_time;
    }

    public void setExit_time(LocalTime exit_time) {
        this.exit_time = exit_time;
    }

    public Ticket getTicketno() {
        return ticketno;
    }

    public void setTicketno(Ticket ticketno) {
        this.ticketno = ticketno;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
