package com.microservices.servicioapp.services;

import com.microservices.servicioapp.exceptions.ResourceNotFoundException;
import com.microservices.servicioapp.entities.ServicioValoracion;
import com.microservices.servicioapp.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public ServicioValoracion saveValoracion(ServicioValoracion servicioValoracion) throws RuntimeException {
        if (!valoracionRepository.findById(servicioValoracion.getValoracionId()).isPresent()) {
            final LocalDateTime fechaHora = LocalDateTime.now(ZoneId.of("GMT-5"));
            servicioValoracion.setFechaHora(fechaHora);
            return valoracionRepository.save(servicioValoracion);
        }
        throw new RuntimeException("El id de valoración ya existe");
    }

    public List<ServicioValoracion> getValoracionesList() {
        return valoracionRepository.findAll();
    }

    public ServicioValoracion getValoracion(int id) {
        if (valoracionRepository.findById(id).isPresent()) {
            return valoracionRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException(
                    "Tal vez la valoración con id del parámetro fue borrada y no se ha actualizado el estado de la página, verifique, recurso no encontrado"
            );
        }
    }
}
