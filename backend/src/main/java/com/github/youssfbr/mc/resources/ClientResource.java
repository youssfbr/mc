package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.dto.request.ClientAllDTO;
import com.github.youssfbr.mc.dto.request.ClientDTO;
import com.github.youssfbr.mc.dto.request.ClientNewDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import com.github.youssfbr.mc.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientResource {

    private final IClientService clientService;

    @GetMapping("/page")
    public Page<ClientAllDTO> listAllPagesClientes(Pageable pageable) { return clientService.listAllPagesClients(pageable); }

    @GetMapping
    public List<ClientAllDTO> listAllClients() { return clientService.listAllClients(); }

    @GetMapping("{clientId}")
    public ClientDTO findClientById(@PathVariable Long clientId) {
        return clientService.findClientById(clientId);
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createClient(@RequestBody @Valid ClientNewDTO clientNewDTO) {

        MessageResponseDTO client = clientService.createClient(clientNewDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).body(client);
    }

    @PutMapping("{clientId}")
    public MessageResponseDTO updateClient(@PathVariable Long clientId, @RequestBody @Valid ClientDTO clientDto) {
        return clientService.updateClient(clientId, clientDto);
    }

    @DeleteMapping("{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }

}
