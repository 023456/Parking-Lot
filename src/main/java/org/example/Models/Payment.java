package org.example.Models;

import java.util.Date;

public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private  int amount;
    private PaymentStatus paymentStatus;
    private Date time;
    private Ticket ticket_number;


    public Payment(PaymentMode paymentMode, int amount, PaymentStatus paymentStatus, Date time, Ticket ticket_number) {
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.time = time;
        this.ticket_number = ticket_number;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Ticket getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(Ticket ticket_number) {
        this.ticket_number = ticket_number;
    }
}
