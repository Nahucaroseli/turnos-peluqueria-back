package com.turnospeluqueria.vimix.dto;

public class EstadisticasTurnoDTO {

    private int cantTurnosMes;

    private int cantTurnosAnio;

    private int cantTurnosDia;


    public EstadisticasTurnoDTO() {
    }


    public void setCantTurnosMes(int cantTurnosMes) {
        this.cantTurnosMes = cantTurnosMes;
    }

    public void setCantTurnosAnio(int cantTurnosAnio) {
        this.cantTurnosAnio = cantTurnosAnio;
    }

    public void setCantTurnosDia(int cantTurnosDia) {
        this.cantTurnosDia = cantTurnosDia;
    }

    public int getCantTurnosMes() {
        return cantTurnosMes;
    }

    public int getCantTurnosAnio() {
        return cantTurnosAnio;
    }

    public int getCantTurnosDia() {
        return cantTurnosDia;
    }
}
