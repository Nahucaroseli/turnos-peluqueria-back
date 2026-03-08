package com.turnospeluqueria.vimix.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date hora;

    @ManyToOne()
    private ServiceHair service;

    @ManyToOne
    private Client client;


    private boolean pendiente;


    public Turno(){
    }

    public Turno(Date hora, ServiceHair serviceId, Client clientId) {
        this.hora = hora;
        this.service = serviceId;
        this.client = clientId;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setServiceId(ServiceHair serviceId) {
        this.service = serviceId;
    }

    public void setClientId(Client clientId) {
        this.client = clientId;
    }

    public void setPendiente(boolean p){this.pendiente = p;}

    public Date getHora() {
        return hora;
    }

    public Long getId() {
        return id;
    }

    public boolean getPendiente(){return pendiente;}

    public ServiceHair getServiceId() {
        return service;
    }

    public Client getClientId() {
        return client;
    }
}
