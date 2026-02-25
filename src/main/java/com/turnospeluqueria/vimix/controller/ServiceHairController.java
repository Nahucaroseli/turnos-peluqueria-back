package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.services.HairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceHairController {

    @Autowired
    private HairService service;

    @GetMapping("/services")
    public ResponseEntity<List<ServiceHair>> getServices(){
        return service.getServices();
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<ServiceHair> getServiceById(@PathVariable Long id){
        return service.getServiceById(id);
    }

    @PostMapping("/services")
    public ResponseEntity<ServiceHair> addService(@RequestBody ServiceHair s){
        return service.addService(s);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<ServiceHair> editService(@PathVariable Long id, @RequestBody ServiceHair s){
        return service.editService(id,s);
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<ServiceHair> deleteService(@PathVariable Long id){
        return service.deleteService(id);
    }

}
