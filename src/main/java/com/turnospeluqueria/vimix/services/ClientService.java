package com.turnospeluqueria.vimix.services;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<Client> editClient(Long id, Client cliente){
        Optional<Client> co = repo.findById(id);
        if(co.isPresent() && cliente.getId()!=null){
                return ResponseEntity.ok(repo.save(cliente));
        }
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Client> deleteClient(Long id){
        Optional<Client> c = repo.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
