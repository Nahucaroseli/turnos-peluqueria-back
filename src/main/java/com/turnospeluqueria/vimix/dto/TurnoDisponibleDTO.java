package com.turnospeluqueria.vimix.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDisponibleDTO {

    private LocalDate fecha;

    private List<LocalTime> horarios;


    public TurnoDisponibleDTO() {
        horarios = new ArrayList<>();
    }

    public void addHorarios(LocalTime h){
        if(!horarios.contains(h)){
            horarios.add(h);
        }
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public List<LocalTime> getHorarios() {
        return horarios;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
