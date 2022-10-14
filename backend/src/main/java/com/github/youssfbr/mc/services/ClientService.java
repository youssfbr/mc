package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.Client;
import com.github.youssfbr.mc.repositories.IClientRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.IClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) { this.clientRepository = clientRepository; }

    @Override
    @Transactional(readOnly = true)
    public List<Client> listAllClients() { return clientRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Client findClientById(Long clientId) {
        return clientRepository
                .findById(clientId)
                .orElseThrow (() -> new ResourceNotFoundException("Cliente com id " + clientId + " não encontrado."));
    }

    @Override
    @Transactional
    public Client insertCategory(Client client) { return clientRepository.save(client); }

}
