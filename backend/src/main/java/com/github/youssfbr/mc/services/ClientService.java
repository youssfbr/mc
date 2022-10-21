package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.dto.request.ClientAllDTO;
import com.github.youssfbr.mc.dto.request.ClientDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import com.github.youssfbr.mc.entities.Client;
import com.github.youssfbr.mc.mappers.ClientMapper;
import com.github.youssfbr.mc.repositories.IClientRepository;
import com.github.youssfbr.mc.services.exceptions.DataIntegrityException;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    private static final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    @Transactional(readOnly = true)
    public Page<ClientAllDTO> listAllPagesClients(Pageable pageable) {
        return clientRepository
                .findAll(pageable)
                .map(clientMapper::allToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientAllDTO> listAllClients() {
        return clientRepository
            .findAll()
            .stream()
            .map(clientMapper::allToDto)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDTO findClientById(Long clientId) {

        Client client = verifyIfExists(clientId);

        return clientMapper.toDto(client);
    }

    @Override
    @Transactional
    public MessageResponseDTO createClient(ClientDTO clientDTO) {

        Client clientToSave = clientMapper.toModel(clientDTO);

        Client savedClient = clientRepository.save(clientToSave);

        return createMessageResponse(savedClient.getId(), "Cliente criado com ID ");
    }

    @Override
    public MessageResponseDTO updateClient(Long clientId, ClientDTO clientDTO) {

        verifyIfExists(clientId);

        Client clientToUpdate = clientMapper.toModel(clientDTO);

        Client updatedClient = clientRepository.save(clientToUpdate);

        return createMessageResponse(updatedClient.getId(), "Cliente atualizado com ID ");
    }

    @Override
    public void deleteClient(Long clientId) {

        verifyIfExists(clientId);

        try {
            clientRepository.deleteById(clientId);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos, endereços ou telefones relacionados.");
        }
    }

    private Client verifyIfExists(Long clientId) {
        return clientRepository
                .findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + clientId + " não encontrado."));
    }

    private MessageResponseDTO createMessageResponse(Long clientId, String message) {
        return MessageResponseDTO
                .builder()
                .id(clientId)
                .message(message + clientId)
                .build();
    }

}
