package com.turnospeluqueria.vimix.controller;

import com.turnospeluqueria.vimix.model.ServiceHair;
import com.turnospeluqueria.vimix.services.HairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ServiceHairController {

    @Autowired
    private HairService service;

    @GetMapping("/services")
    public List<ServiceHair> getServices(){
        return service.getServices();
    }

}
