package com.github.youssfbr.mc.services.utils;

import com.github.youssfbr.mc.dto.request.ClientNewDTO;
import com.github.youssfbr.mc.entities.enums.ClientType;
import com.github.youssfbr.mc.resources.exceptions.FieldMessage;

import javax.validation.ConstraintValidator;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidatorContext;

public class CpfOrCnpjValidator implements ConstraintValidator<CpfOrCnpj, ClientNewDTO> {

    @Override
    public void initialize(CpfOrCnpj ann) {
    }

    @Override
    public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getClientType().equals(ClientType.PESSOA_FISICA.getId()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CPF inválido"));
        }

        if (objDto.getClientType().equals(ClientType.PESSOA_JURIDICA.getId()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CNPJ inválido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}
