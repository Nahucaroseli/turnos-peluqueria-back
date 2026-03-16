package com.turnospeluqueria.vimix.dto;

import com.turnospeluqueria.vimix.model.Client;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaTurnoDTO {

    private LocalDate fecha;

    private LocalTime hora;

    private Long service;

    private String name;

    private String phone;

    public ReservaTurnoDTO(LocalDate fecha, LocalTime hora, Long service, String name, String phone) {
        this.fecha = fecha;
        this.hora = hora;
        this.service = service;
        this.name = name;
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
