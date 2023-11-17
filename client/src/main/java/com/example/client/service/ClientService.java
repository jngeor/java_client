package com.example.client.service;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientListDto;

import java.util.List;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto);
    List<ClientListDto> listAll();
    ClientDto updateClient(String id,ClientDto clientDto);
}
