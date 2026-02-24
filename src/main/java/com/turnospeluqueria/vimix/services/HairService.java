package com.turnospeluqueria.vimix.services;

import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.repository.ServiceHairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairService {

    @Autowired
    private ServiceHairRepository repo;

    public ResponseEntity<List<ServiceHair>> getServices() {
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<ServiceHair> getServiceById(Long id){
        Optional<ServiceHair> sh = repo.findById(id);
        if(sh.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sh.get());

    }

    public ResponseEntity<ServiceHair> addService(ServiceHair service){
        return ResponseEntity.ok(repo.save(service));
    }

    public ResponseEntity<ServiceHair> editService(Long id,ServiceHair s){
        Optional<ServiceHair> sh = repo.findById(id);
        if(sh.isPresent() && s.getId()!=null){
            return ResponseEntity.ok(repo.save(s));
        }
        return ResponseEntity.internalServerError().build();
    }


    public ResponseEntity<ServiceHair> deleteService(Long id){
        Optional<ServiceHair> sh = repo.findById(id);
        if(sh.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
