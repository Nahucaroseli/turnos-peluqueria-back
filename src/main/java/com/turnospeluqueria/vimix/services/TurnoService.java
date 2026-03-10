package com.turnospeluqueria.vimix.services;


import com.turnospeluqueria.vimix.dto.ReservaTurnoDTO;
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

    public ResponseEntity<Turno> addTurno(ReservaTurnoDTO t){
        Optional<ServiceHair> serviceHair = repository.findById(t.getService());
        System.out.println(t.getService());
        if(serviceHair.isEmpty()){
            return ResponseEntity.internalServerError().build();
        }
        Client c = repositoryClient.save(t.getClient());

        if(c.getId() != null){
            Turno turno = new Turno();
            turno.setService(serviceHair.get());
            turno.setPendiente(false);
            turno.setClient(c);
            turno.setFecha(t.getFecha());
            turno.setHora(t.getHora());
            return ResponseEntity.ok(repo.save(turno));
        }
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Turno> getTurnoById(Long id){
        Optional<Turno> turno = repo.findById(id);
        if(turno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno.get());
    }

    public ResponseEntity<Turno> deleteTurno(Long id){
        Optional<Turno> turno = repo.findById(id);
        if(turno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
