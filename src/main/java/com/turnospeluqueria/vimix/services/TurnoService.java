package com.turnospeluqueria.vimix.services;


import com.turnospeluqueria.vimix.model.Turno;
import com.turnospeluqueria.vimix.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repo;

    public TurnoService(){

    }

    public ResponseEntity<List<Turno>> getTurnos(){
        return ResponseEntity.ok(repo.findAll());
    }


}
