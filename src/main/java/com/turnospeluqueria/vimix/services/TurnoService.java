package com.turnospeluqueria.vimix.services;


import com.turnospeluqueria.vimix.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repo;

    public TurnoService(){

    }

    public ResponseEntity<Turno> getTurnos(){
        return ResponseEntity.ok(repo.findAll());
    }


}
