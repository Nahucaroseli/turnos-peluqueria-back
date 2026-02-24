package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients(){
        return service.getClients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return service.getClientById(id);
    }


    @PostMapping("/clients")
    public Client addClient(@RequestBody Client cliente){
        return service.addClient(cliente);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> editClient(@PathVariable Long id, @RequestBody Client client){
        return service.editClient(id,client);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id){
        return service.deleteClient(id);
    }

}
