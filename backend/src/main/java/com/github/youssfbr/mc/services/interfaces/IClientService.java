package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> listAllClients();
    Client findClientById(Long clientId);
    Client insertCategory(Client client);

}
