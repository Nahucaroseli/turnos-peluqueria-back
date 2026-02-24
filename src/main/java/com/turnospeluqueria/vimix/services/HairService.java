package com.turnospeluqueria.vimix.services;

import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.repository.ServiceHairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HairService {

    @Autowired
    private ServiceHairRepository repo;

    public ResponseEntity<List<ServiceHair>> getServices() {
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<ServiceHair> addService(ServiceHair service){
        return ResponseEntity.ok(repo.save(service));
    }
}
