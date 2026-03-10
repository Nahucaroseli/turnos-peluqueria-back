package com.turnospeluqueria.vimix.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    @ManyToOne()
    private ServiceHair service;

    @ManyToOne
    private Client client;


    private boolean pendiente;


    public Turno(){
    }

    public Turno(LocalDate fecha, LocalTime hora, ServiceHair service, Client client) {
        this.fecha = fecha;
        this.hora = hora;
        this.service = service;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public ServiceHair getService() {
        return service;
    }

    public Client getClient() {
        return client;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setService(ServiceHair service) {
        this.service = service;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }
}
