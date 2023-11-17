package com.example.client.service;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientListDto;
import com.example.client.entity.Client;
import com.example.client.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    @DisplayName("when insert record get client")
    void whenInsertRecordGetClient() {
        ClientDto clientDto = new ClientDto("Jorge", "Pantigoso", "Cossío");
        when(clientRepository.save(any(Client.class))).thenReturn(new Client("Jorge", "Pantigoso", "Cossío"));

        ClientDto result = clientService.addClient(clientDto);
        assertNotNull(result);
        assertEquals(clientDto.getName(), result.getName());
        assertEquals(clientDto.getLastName(), result.getLastName());
        assertEquals(clientDto.getMotherName(), result.getMotherName());

        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    @DisplayName("when list records get clients")
    void whenListRecordsGetClients() {

        Client client = new Client("Jorge", "Pantigoso", "Cossío");
        List<Client> list = new ArrayList<>();
        list.add(client);
        when(clientRepository.findAll()).thenReturn(list);

        List<ClientListDto> listDtos = clientService.listAll();
        assertNotNull(listDtos);
        assertEquals(listDtos.size(), 1);

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("when update record get client")
    void whenUpdateRecordGetClient() {
        ClientDto clientDto = new ClientDto("Jorge", "Pantigoso", "Cossío");
        Client client = new Client("Jorge", "Pantigoso", "Cossío");
        when(clientRepository.findById(any())).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientDto result = clientService.updateClient(client.getId(), clientDto);
        assertNotNull(result);
        assertEquals(clientDto.getName(), result.getName());
        assertEquals(clientDto.getLastName(), result.getLastName());
        assertEquals(clientDto.getMotherName(), result.getMotherName());

        verify(clientRepository, times(1)).save(any(Client.class));
    }

}
