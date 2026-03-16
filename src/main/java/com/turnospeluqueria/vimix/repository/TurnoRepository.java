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

    @Query(nativeQuery = true, value="Select count(*) from turno where fecha >= date_trunc('month', current_date -" +
            "interval '1' month) and fecha < date_trunc('month',current_date)")
    int findCantTurnosLastMonth();

    @Query(nativeQuery = true, value = "Select count(*) from turno")
    int findCantTurnosYear();

    @Query(nativeQuery = true, value = "Select count(*) from turno where fecha >= date_trunc('day', current_date)" +
            "and fecha < date_trunc('day', current_date + interval '1 day')")
    int findCantTurnosDay();

    @Query("SELECT COUNT(t) FROM Turno t WHERE t.fecha=:fecha")
    int findCantTurnosByDay(@Param("fecha") LocalDate fecha);

}

