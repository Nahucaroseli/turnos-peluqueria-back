package com.turnospeluqueria.vimix.repository;

import com.turnospeluqueria.vimix.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
