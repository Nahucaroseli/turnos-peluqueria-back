package com.turnospeluqueria.vimix.repository;

import com.turnospeluqueria.vimix.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    @Query("SELECT t.hora FROM Turno t WHERE t.fecha=:fecha")
    List<LocalTime> findHorariosByFecha(@Param("fecha")LocalDate fecha);

    //Agregar query
    int findCantTurnosLastMonth();
    
    //Agregar query
    int findCantTurnosYear();
    //Agregar query

    int findCantTurnosDay();
}
