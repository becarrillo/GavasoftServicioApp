package com.microservices.servicioapp.services;

import com.microservices.servicioapp.entities.Servicio;
import com.microservices.servicioapp.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public Servicio save(Servicio servicio) {
        final List<Servicio> listaServicios = servicioRepository.findAll();
        for (var i = 0; i < listaServicios.size(); i++) {
            if (servicio.getServicioNombre().equals(listaServicios.get(i).getServicioNombre()) || servicio.getImgUrl().equals(listaServicios.get(i).getImgUrl())) {
                return null;
            }
        }
        return servicioRepository.save(servicio);
    }

    public List<Servicio> getAll()  {
        return servicioRepository.findAll();
    }

    public Servicio getOne(String servicioNombre) {
        final List<Servicio> serviciosList = servicioRepository.findAll();
        final Optional<Servicio> servicioOpt = serviciosList.stream().filter(s -> Objects.equals(s.getServicioNombre(), servicioNombre)).findAny();

        return servicioOpt.orElse(null);
    }

    public Servicio getOneById(String servicioId) {
        final Optional<Servicio> servicioOpt = servicioRepository.findById(servicioId);
        return servicioOpt.orElse(null);
    }

    public Servicio updateOne(Servicio foundServicio, Servicio servicio) {
        foundServicio.setServicioNombre(servicio.getServicioNombre());
        foundServicio.setDescripcion(servicio.getDescripcion());
        foundServicio.setDuracion(servicio.getDuracion());
        foundServicio.setPrecio(servicio.getPrecio());
        foundServicio.setImgUrl(servicio.getImgUrl());
        return servicioRepository.save(foundServicio);
    }

    public String delete(String servicioId) {
        servicioRepository.deleteById(servicioId);
        return servicioId;
    }
}
