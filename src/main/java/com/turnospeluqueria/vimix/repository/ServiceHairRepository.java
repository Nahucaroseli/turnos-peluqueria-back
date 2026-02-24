package com.turnospeluqueria.vimix.repository;

import com.turnospeluqueria.vimix.model.ServiceHair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceHairRepository extends JpaRepository<ServiceHair,Long> {

}
