package com.turnospeluqueria.vimix.dto;

import com.turnospeluqueria.vimix.model.Client;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaTurnoDTO {

    private LocalDate fecha;

    private LocalTime hora;

    private Long service;

    private Client client;

    public ReservaTurnoDTO(LocalDate fecha, LocalTime hora, Long service, Client client) {
        this.fecha = fecha;
        this.hora = hora;
        this.service = service;
        this.client = client;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public Client getClient() {
        return client;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Long getService() {
        return service;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setService(Long service) {
        this.service = service;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
