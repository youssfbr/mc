package com.github.youssfbr.mc.mappers;

import com.github.youssfbr.mc.dto.request.ClientAllDTO;
import com.github.youssfbr.mc.dto.request.ClientDTO;
import com.github.youssfbr.mc.entities.Client;
import com.github.youssfbr.mc.entities.enums.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Client toModel(ClientDTO clientDTO);

    ClientDTO toDto(Client client) ;

    ClientAllDTO allToDto(Client client);

    default String setClientType(ClientType status) {
        return status.getName();
    }

}
