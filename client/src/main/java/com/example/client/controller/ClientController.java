package com.example.client.controller;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientListDto;
import com.example.client.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> crearCliente(@Valid @RequestBody ClientDto client) {
        return ResponseEntity.ok(clientService.addClient(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientListDto>> listarClientes() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> actualizarCliente(
            @PathVariable String id,
            @Valid
            @RequestBody ClientDto cliente) {
        return ResponseEntity.ok(clientService.updateClient(id, cliente));
    }
}
