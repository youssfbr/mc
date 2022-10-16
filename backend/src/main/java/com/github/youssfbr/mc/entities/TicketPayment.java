package com.github.youssfbr.mc.entities;

import com.github.youssfbr.mc.entities.enums.StatePayment;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_ticket_payment")
public class TicketPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Date expirationDate;
    private Date paymentDate;

    public TicketPayment() { }

    public TicketPayment(Long id, StatePayment statePayment, Order order, Date expirationDate, Date paymentDate) {
        super(id, statePayment, order);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
