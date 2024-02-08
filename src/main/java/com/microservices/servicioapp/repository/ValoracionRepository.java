package com.microservices.servicioapp.repository;

import com.microservices.servicioapp.entities.ServicioValoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<ServicioValoracion, Integer> {
}
