package com.github.youssfbr.mc.services.utils;

import com.github.youssfbr.mc.dto.request.ClientNewDTO;
import com.github.youssfbr.mc.entities.enums.ClientType;
import com.github.youssfbr.mc.repositories.IClientRepository;
import com.github.youssfbr.mc.resources.exceptions.FieldMessage;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CpfOrCnpjEmailInsertValidator implements ConstraintValidator<CpfOrCnpjEmailInsert, ClientNewDTO> {

    private final IClientRepository clientRepository;

    @Override
    public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getClientType().equals(ClientType.PESSOA_FISICA.getId()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CPF inválido."));
        }

        if (objDto.getClientType().equals(ClientType.PESSOA_JURIDICA.getId()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CNPJ inválido."));
        }

        boolean emailExists = clientRepository.existsByEmail(objDto.getEmail());
        if (emailExists) list.add(new FieldMessage("email", "e-mail já existente."));

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}
