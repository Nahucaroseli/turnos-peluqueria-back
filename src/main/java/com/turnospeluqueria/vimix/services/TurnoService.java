package com.turnospeluqueria.vimix.services;


import com.turnospeluqueria.vimix.dto.EstadisticasTurnoDTO;
import com.turnospeluqueria.vimix.dto.ReservaTurnoDTO;
import com.turnospeluqueria.vimix.dto.TurnoDisponibleDTO;
import com.turnospeluqueria.vimix.model.Client;
import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.model.Turno;
import com.turnospeluqueria.vimix.repository.ClientRepository;
import com.turnospeluqueria.vimix.repository.ServiceHairRepository;
import com.turnospeluqueria.vimix.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repo;

    @Autowired
    private ServiceHairRepository repository;

    @Autowired
    private ClientRepository repositoryClient;

    public TurnoService(){

    }

    public ResponseEntity<List<Turno>> getTurnos(){
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<Turno> addTurno(ReservaTurnoDTO t){
        Optional<ServiceHair> serviceHair = repository.findById(t.getService());
        System.out.println(t.getService());
        if(serviceHair.isEmpty()){
            return ResponseEntity.internalServerError().build();
        }
        Client newClient = new Client();

        newClient.setName(t.getName());
        newClient.setPhone(t.getPhone());

        Client c = repositoryClient.save(newClient);

        if(c.getId() != null){
            Turno turno = new Turno();
            turno.setService(serviceHair.get());
            turno.setPendiente(false);
            turno.setClient(c);
            turno.setFecha(t.getFecha());
            turno.setHora(t.getHora());
            return ResponseEntity.ok(repo.save(turno));
        }
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Turno> getTurnoById(Long id){
        Optional<Turno> turno = repo.findById(id);
        if(turno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno.get());
    }

    public ResponseEntity<Turno> deleteTurno(Long id){
        Optional<Turno> turno = repo.findById(id);
        if(turno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<TurnoDisponibleDTO> getTurnosDisponibles(LocalDate fecha){
        List<LocalTime> horarios = generarHorarios();
        List<LocalTime> ocupados = repo.findHorariosByFecha(fecha);
        TurnoDisponibleDTO dto = new TurnoDisponibleDTO();
        dto.setFecha(fecha);
        for(LocalTime l:horarios){
            if(!ocupados.contains(l)){
                dto.addHorarios(l);
            }
        }
        return ResponseEntity.ok(dto);
    }

    public ResponseEntity<EstadisticasTurnoDTO> getEstadisticasTurnos(){
        int cantTurnosMes = repo.findCantTurnosLastMonth();
        int cantTurnosAnio = repo.findCantTurnosYear();
        int cantTurnosDia = repo.findCantTurnosDay();
        EstadisticasTurnoDTO dto = new EstadisticasTurnoDTO();
        dto.setCantTurnosAnio(cantTurnosAnio);
        dto.setCantTurnosDia(cantTurnosDia);
        dto.setCantTurnosMes(cantTurnosMes);
        return ResponseEntity.ok(dto);
    }


    private List<LocalTime> generarHorarios(){
        List<LocalTime> horarios = new ArrayList<>();

        LocalTime inicio = LocalTime.of(9,0);
        LocalTime fin = LocalTime.of(18,0);

        while(inicio.isBefore(fin)){
            horarios.add(inicio);
            inicio = inicio.plusMinutes(30);
        }

        return horarios;

    }

}
