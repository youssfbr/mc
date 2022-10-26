package com.github.youssfbr.mc.services.utils;

import com.github.youssfbr.mc.dto.request.ClientDTO;
import com.github.youssfbr.mc.entities.Client;
import com.github.youssfbr.mc.repositories.IClientRepository;
import com.github.youssfbr.mc.resources.exceptions.FieldMessage;
import com.github.youssfbr.mc.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EmailUpdateValidator implements ConstraintValidator<EmailUpdate, ClientDTO> {

    private final HttpServletRequest request;
    private final IClientRepository clientRepository;
    private final ClientService clientService;

    @Override
    public void initialize(EmailUpdate ann) { }

    @Override
    public boolean isValid(ClientDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long uriId = Long.parseLong(map.get("clientId"));

        List<FieldMessage> list = new ArrayList<>();

        Client client = clientService.verifyIfClientExists(uriId);

        if(clientRepository.existsByEmail(objDto.getEmail()) && !client.getEmail().equals(objDto.getEmail())){
            list.add(new FieldMessage("email", "e-mail já existente."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}
