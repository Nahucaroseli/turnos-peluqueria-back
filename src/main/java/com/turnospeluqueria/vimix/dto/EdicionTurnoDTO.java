package com.turnospeluqueria.vimix.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EdicionTurnoDTO {


    private Long idTurno;

    private LocalDate fecha;

    private LocalTime hora;

    private Long service;

    private boolean pendiente;


    public EdicionTurnoDTO(LocalDate fecha, LocalTime hora, Long service, Long idTurno, boolean pendiente) {
        this.fecha = fecha;
        this.hora = hora;
        this.service = service;
        this.idTurno = idTurno;
        this.pendiente = pendiente;
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

    public boolean getPendiente(){
        return pendiente;
    }
}
