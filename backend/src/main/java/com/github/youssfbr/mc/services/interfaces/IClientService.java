package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.dto.request.ClientAllDTO;
import com.github.youssfbr.mc.dto.request.ClientDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientService {

    Page<ClientAllDTO> listAllPagesClients(Pageable pageable);
    List<ClientAllDTO> listAllClients();
    ClientDTO findClientById(Long clientId) throws IllegalAccessException;
    MessageResponseDTO createClient(ClientDTO clientDTO);
    MessageResponseDTO updateClient(Long clientId, ClientDTO clientDTO);
    void deleteClient(Long clientId);

}
