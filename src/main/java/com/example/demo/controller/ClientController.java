package com.example.demo.controller;

import com.example.demo.controller.dtos.requests.ClientRequest;
import com.example.demo.controller.dtos.responses.ClientResponse;
import com.example.demo.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private IClientService service;

    @GetMapping
    private List<ClientResponse> list(){
        return service.list();
    }

    @GetMapping("{id}")
    private ClientResponse get(@PathVariable Long id){
        return service.get(id);
    }


    @PostMapping
    private ClientResponse create (@RequestBody ClientRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    private ClientResponse update(@PathVariable Long id, @RequestBody ClientRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }
}
