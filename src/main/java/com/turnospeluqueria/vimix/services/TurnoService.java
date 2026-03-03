package com.turnospeluqueria.vimix.services;


import com.turnospeluqueria.vimix.dto.TurnoDTO;
import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.model.Turno;
import com.turnospeluqueria.vimix.repository.ClientRepository;
import com.turnospeluqueria.vimix.repository.ServiceHairRepository;
import com.turnospeluqueria.vimix.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repo;

    @Autowired
    private ServiceHairRepository repository;

    @Autowired
    private ClientRepository repositoryClient;

    public TurnoService(){

    }

    public ResponseEntity<List<Turno>> getTurnos(){
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<Turno> addTurno(TurnoDTO t){
        Optional<ServiceHair> serviceHair = repository.findById(t.getService());
        System.out.println(t.getService());
        if(serviceHair.isEmpty()){
            return ResponseEntity.internalServerError().build();
        }
        Client c = repositoryClient.save(t.getClient());

        if(c.getId() != null){
            Turno turno = new Turno();
            turno.setServiceId(serviceHair.get());
            turno.setClientId(c);
            turno.setHora(t.getHora());
            return ResponseEntity.ok(repo.save(turno));
        }
        return ResponseEntity.internalServerError().build();
    }


}
