package com.github.youssfbr.mc.dto.request;

import com.github.youssfbr.mc.services.utils.CpfOrCnpjEmailInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CpfOrCnpjEmailInsert
public class ClientNewDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String name;

    @Email
    @NotEmpty
    private String email;

    private String cpfOrCnpj;

    private Integer clientType;

    @NotEmpty
    private String patio;

    @NotEmpty
    private String number;

    private String complement;
    private String district;
    private String cep;

    private Long cityId;

    @NotEmpty
    private String phone1;
    private String phone2;
    private String phone3;

}
