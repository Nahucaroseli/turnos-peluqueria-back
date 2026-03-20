package com.turnospeluqueria.vimix.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EdicionTurnoDTO {

    private LocalDate fecha;

    private LocalTime hora;

    private Long service;


    public EdicionTurnoDTO(LocalDate fecha, LocalTime hora, Long service) {
        this.fecha = fecha;
        this.hora = hora;
        this.service = service;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Long getService() {
        return service;
    }
}
