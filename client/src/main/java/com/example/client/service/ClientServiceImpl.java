package com.example.client.service;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientListDto;
import com.example.client.entity.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Guardado de un nuevo cliente.
     *
     * @param clientDto cliente a guardar.
     */
    public ClientDto addClient(ClientDto clientDto) {
        Client client = clientRepository.save(new Client(clientDto.getName(),
                clientDto.getLastName(),
                clientDto.getMotherName()));
        if (client.isActive()) {
            return new ClientDto(client.getName(), client.getLastName(), client.getMotherName());
        }

        return null;
    }

    public List<ClientListDto> listAll() {
        List<ClientListDto> clients = new ArrayList<>();
        var list = clientRepository.findAll();
        list.forEach(client -> {
            ClientListDto clientListDto = new ClientListDto(client.getId(),
                    client.getName(), client.getLastName(), client.getMotherName());
            clients.add(clientListDto);
        });

        return clients;
    }

    /**
     * Guardado de un nuevo cliente.
     *
     * @param id cliente a buscar.
     * @param clientDto cliente a modificar.
     */
    public ClientDto updateClient(String id, ClientDto clientDto) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDto.getName());
            client.setLastName(clientDto.getLastName());
            client.setMotherName(clientDto.getMotherName());
            clientRepository.save(client);
        }

        return clientDto;
    }

}
