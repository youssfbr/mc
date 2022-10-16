package com.github.youssfbr.mc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.youssfbr.mc.entities.enums.StatePayment;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer statePayment;

    @MapsId
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    protected Payment() { }

    protected Payment(Long id, StatePayment statePayment, Order order) {
        this.id = id;
        this.statePayment = statePayment.getId();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatePayment getStatePayment() throws IllegalAccessException {
        return StatePayment.toEnum(statePayment);
    }

    public void setStatePayment(StatePayment statePayment) {
        this.statePayment = statePayment.getId();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
