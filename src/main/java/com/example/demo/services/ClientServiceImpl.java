package com.example.demo.services;

import com.example.demo.controller.dtos.requests.ClientRequest;
import com.example.demo.controller.dtos.responses.ClientResponse;
import com.example.demo.entities.Client;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository repository;

    @Override
    public ClientResponse create(ClientRequest request) {
        return from(repository.save(from(request)));
    }

    @Override
    public ClientResponse get(Long id) {
        return from(findAndEnsuereExist(id));
    }

    @Override
    public Client getClient(Long id) {
        return findAndEnsuereExist(id);
    }

    @Override
    public List<ClientResponse> list() {
        return repository.findAll()
                .stream().map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse update(Long id, ClientRequest request) {
        Client client = findAndEnsuereExist(id);
        client.setName(request.getName());
        client.setProduct(request.getProduct());
        client.setQuantityOfProducts(request.getQuantityOfProducts());
        client.setTypeOfService(request.getTypeOfService());
        return from(repository.save(client));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsuereExist(id));
    }

    private Client from(ClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());
        client.setProduct(request.getProduct());
        client.setQuantityOfProducts(request.getQuantityOfProducts());
        client.setTypeOfService(request.getTypeOfService());
        return client;
    }

    private ClientResponse from(Client client){
        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setProduct(client.getProduct());
        response.setQuantityOfProducts(client.getQuantityOfProducts());
        response.setTypeOfService(client.getTypeOfService());
        return response;
    }

    private Client findAndEnsuereExist(Long id){
        return repository.findById(id).orElseThrow(() -> (new RuntimeException("Not found")));
    }
}
