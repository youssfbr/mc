package com.github.youssfbr.mc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.youssfbr.mc.entities.enums.StatePayment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer statePayment;

    @MapsId
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    protected Payment(Long id, StatePayment statePayment, Order order) {
        this.id = id;
        this.order = order;
        setStatePayment(statePayment);
    }

    public StatePayment getStatePayment() {
        return StatePayment.toEnum(statePayment);
    }

    public void setStatePayment(StatePayment statePayment) {
        if (statePayment != null) this.statePayment = statePayment.getId();
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
