package com.example.demo.services.interfaces;

import com.example.demo.controller.dtos.requests.ClientRequest;
import com.example.demo.controller.dtos.responses.ClientResponse;
import com.example.demo.entities.Client;

import java.util.List;

public interface IClientService {
    ClientResponse create(ClientRequest request);

    ClientResponse get(Long id);

    List<ClientResponse> list();

    ClientResponse update(Long id, ClientRequest request);

    void delete(Long id);

    Client getClient(Long id);
}
