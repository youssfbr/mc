package com.github.youssfbr.mc.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.youssfbr.mc.entities.Address;
import com.github.youssfbr.mc.entities.Order;
import com.github.youssfbr.mc.services.utils.EmailUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@EmailUpdate
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String name;

    @Email
    @NotEmpty
    private String email;

    private String cpfOrCnpj;

    private String clientType;

    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_phone")
    private Set<String> phones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

}
