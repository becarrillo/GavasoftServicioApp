package com.microservices.servicioapp.services;

import com.microservices.servicioapp.exceptions.ResourceNotFoundException;
import com.microservices.servicioapp.entities.Valoracion;
import com.microservices.servicioapp.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * @author Brando Elí Carrillo Pérez
 * @implNote (es) Instancia un objeto contenedor de puntuación y comentario sobre algún servicio del Spa con servicio_id
 */
@Service
public class ValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepository;

    public Valoracion save(Valoracion valoracion) throws RuntimeException {
        final LocalDate fecha = LocalDate.now(ZoneId.of("GMT-5"));  // Captura de hora local Bogotá
        valoracion.setFecha(fecha);
        return valoracionRepository.save(valoracion);
    }

    public List<Valoracion> listAll() {
        return valoracionRepository.findAll();
    }

    public Valoracion getValoracion(String id) {
        if (valoracionRepository.findById(id).isPresent()) {
            return valoracionRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(
                    "Tal vez la valoración con id del parámetro fue borrada y no se ha actualizado el estado de la página, verifique, recurso no encontrado"
            );
        }
    }

    public String deleteOneById(String servicioValoracionId) {
        if (valoracionRepository.findAll().stream().noneMatch(v -> v.getValoracionId() == servicioValoracionId)) {
            return null;
        }
        valoracionRepository.deleteById(servicioValoracionId);
        return servicioValoracionId;
    }
}
