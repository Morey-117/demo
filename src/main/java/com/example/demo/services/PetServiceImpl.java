package com.example.demo.services;

import com.example.demo.controller.dtos.requests.PetRequest;
import com.example.demo.controller.dtos.responses.PetResponse;
import com.example.demo.entities.Pet;
import com.example.demo.repositories.IPetRepository;
import com.example.demo.services.interfaces.IClientService;
import com.example.demo.services.interfaces.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements IPetService {
    @Autowired
    private IPetRepository repository;
    @Autowired
    private IClientService clientService;

    @Override
    public PetResponse create(PetRequest request) {
        return from(repository.save(from(request)));
    }

    @Override
    public List<PetResponse> list() {
        return repository.findAll()
                .stream().map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public PetResponse get(Long id) {
        return from(findAndEnsureExist(id));
    }

    @Override
    public PetResponse update(Long id, PetRequest request) {
        Pet pet = findAndEnsureExist(id);
        pet.setName(request.getName());
        pet.setBreed(request.getBreed());
        pet.setOwnerPhone(request.getOwnerPhone());
        pet.setClient(clientService.getClient(request.getClient()));
        return from(repository.save(pet));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Pet from(PetRequest request) {
        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setBreed(request.getBreed());
        pet.setOwnerPhone(request.getOwnerPhone());
        pet.setClient(clientService.getClient(request.getClient()));
        return pet;
    }

    private PetResponse from(Pet pet){
        PetResponse response = new PetResponse();
        response.setId(pet.getId());
        response.setName(pet.getName());
        response.setBreed(pet.getBreed());
        response.setOwnerPhone(pet.getOwnerPhone());
        response.setClient(pet.getClient().getName());
        return response;
    }

    private Pet findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> (new RuntimeException("Not found")));
    }
}
