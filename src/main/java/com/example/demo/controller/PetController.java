package com.example.demo.controller;

import com.example.demo.controller.dtos.requests.PetRequest;
import com.example.demo.controller.dtos.responses.PetResponse;
import com.example.demo.services.interfaces.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController {
    @Autowired
    private IPetService service;

    @GetMapping
    private List<PetResponse> list(){
        return service.list();
    }

    @GetMapping("{id}")
    private PetResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    private PetResponse create(@RequestBody PetRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    private PetResponse update(@PathVariable Long id, @RequestBody PetRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }
}
