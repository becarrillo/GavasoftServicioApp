package com.microservices.servicioapp.controller;

import com.microservices.servicioapp.entities.Valoracion;
import com.microservices.servicioapp.services.ServicioService;
import com.microservices.servicioapp.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/valoraciones")
public class ValoracionController {
    @Autowired
    private ValoracionService valoracionService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping(path = "/")
    public List<Valoracion> obtenerValoraciones() {
        return valoracionService.listAll();
    }

    @PostMapping(path = "/servicios/{servicioId}/agregar/nueva")
    public Valoracion valorarServicio(
            @PathVariable("servicioId") String servicioId,
            @RequestBody() Valoracion valoracion
    ) {
        return valoracionService.save(valoracion);
    }

    @GetMapping(path = "/{servicioValoracionId}/borrar")
    public String eliminarValoracionDeServicio(@PathVariable("servicioValoracionId") String servicioValoracionId) {
        String message;
        message = "Valoración con id ";
        message = message.concat(valoracionService.deleteOneById(servicioValoracionId));
        message = message.concat(" eliminada con éxito");
        return message;
    }
}
