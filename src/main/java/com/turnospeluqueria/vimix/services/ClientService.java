package com.turnospeluqueria.vimix.services;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> getClients() {
        return repo.findAll();
    }

    public Client addClient(Client cliente){
        return repo.save(cliente);
    }

}
