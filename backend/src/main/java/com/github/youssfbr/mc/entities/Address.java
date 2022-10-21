package com.github.youssfbr.mc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String patio;
    private String number;
    private String complement;
    private String district;
    private String cep;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
