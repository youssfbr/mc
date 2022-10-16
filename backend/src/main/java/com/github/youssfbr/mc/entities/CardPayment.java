package com.github.youssfbr.mc.entities;

import com.github.youssfbr.mc.entities.enums.StatePayment;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_card_payment")
public class CardPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer numberPayments;

    public CardPayment() { }

    public CardPayment(Long id, StatePayment statePayment, Order order, Integer numberPayments) {
        super(id, statePayment, order);
        this.numberPayments = numberPayments;
    }

    public Integer getNumberPayments() {
        return numberPayments;
    }

    public void setNumberPayments(Integer numberPayments) {
        this.numberPayments = numberPayments;
    }

}
