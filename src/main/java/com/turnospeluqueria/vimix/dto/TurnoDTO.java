package com.turnospeluqueria.vimix.dto;

import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.model.ServiceHair;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class TurnoDTO {

    private Date hora;

    private Long service;

    private Client client;

    public TurnoDTO(Date hora, Long serviceId, Client clientId) {
        this.hora = hora;
        this.service = serviceId;
        this.client = clientId;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setService(Long service) {
        this.service = service;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getHora() {
        return hora;
    }

    public Long getService() {
        return service;
    }

    public Client getClient() {
        return client;
    }
}
