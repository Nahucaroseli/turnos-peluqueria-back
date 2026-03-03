package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnoController {

    @Autowired
    private TurnoService service;


    public TurnoController(){

    }

    @GetMapping("/turnos")
    public ResponseEntity<Turno> getTurnos(){
        return service.getTurnos();
    }


}
