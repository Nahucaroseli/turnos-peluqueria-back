package com.turnospeluqueria.vimix.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date hora;

    @ManyToOne()
    private ServiceHair serviceId;

    @ManyToOne()
    private Client clientId;


    public Turno(){
        
    }

    public Turno(Date hora, ServiceHair serviceId, Client clientId) {
        this.hora = hora;
        this.serviceId = serviceId;
        this.clientId = clientId;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setServiceId(ServiceHair serviceId) {
        this.serviceId = serviceId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Date getHora() {
        return hora;
    }

    public Long getId() {
        return id;
    }

    public ServiceHair getServiceId() {
        return serviceId;
    }

    public Client getClientId() {
        return clientId;
    }
}
