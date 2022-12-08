package com.example.demo.services.interfaces;

import com.example.demo.controller.dtos.requests.PetRequest;
import com.example.demo.controller.dtos.responses.PetResponse;

import java.util.List;

public interface IPetService {
    PetResponse create(PetRequest request);

    List<PetResponse> list();

    PetResponse get(Long id);

    PetResponse update(Long id, PetRequest request);

    void delete(Long id);
}
