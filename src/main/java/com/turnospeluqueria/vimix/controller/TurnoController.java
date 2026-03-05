package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.dto.TurnoDTO;
import com.turnospeluqueria.vimix.model.Turno;
import com.turnospeluqueria.vimix.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnoController {

    @Autowired
    private TurnoService service;


    public TurnoController(){

    }

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> getTurnos(){
        return service.getTurnos();
    }

    @PostMapping("/turnos")
    public ResponseEntity<Turno> addTurno(@RequestBody TurnoDTO t){
        return service.addTurno(t);
    }

    @GetMapping("/turnos/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Long id){
        return service.getTurnoById(id);
    }

    @DeleteMapping("/turnos/{id}")
    public ResponseEntity<Turno> deleteTurno(@PathVariable Long id){
        return service.deleteTurno(id);
    }


}
