package com.microservices.servicioapp.repository;

import com.microservices.servicioapp.entities.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, String> {
}
