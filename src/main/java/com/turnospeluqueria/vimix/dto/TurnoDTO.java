package com.turnospeluqueria.vimix.dto;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.model.ServiceHair;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;

public class TurnoDTO {

    private LocalDate hora;

    private Long service;

    private Client client;

    public TurnoDTO(LocalDate hora, Long serviceId, Client clientId) {
        this.hora = hora;
        this.service = serviceId;
        this.client = clientId;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public void setService(Long service) {
        this.service = service;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getHora() {
        return hora;
    }

    public Long getService() {
        return service;
    }

    public Client getClient() {
        return client;
    }
}
