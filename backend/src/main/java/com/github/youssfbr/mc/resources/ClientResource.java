package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.Client;
import com.github.youssfbr.mc.services.interfaces.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    private final IClientService clientService;

    public ClientResource(IClientService clientService) { this.clientService = clientService; }

    @GetMapping
    public List<Client> listAllClients() {
        return clientService.listAllClients();
    }

    @GetMapping("{clientId}")
    public Client listClientById(@PathVariable Long clientId) { return clientService.findClientById(clientId); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertCategory(@RequestBody Client client) {
        return clientService.insertCategory(client);
    }

}
