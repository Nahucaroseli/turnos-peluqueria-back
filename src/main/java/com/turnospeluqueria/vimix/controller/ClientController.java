package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public List<Client> getClients(){
        return service.getClients();
    }


    @PostMapping("/clients")
    public Client addClient(@RequestBody Client cliente){
        return service.addClient(cliente);
    }


}
