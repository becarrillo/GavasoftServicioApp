package com.microservices.servicioapp.controller;

import com.microservices.servicioapp.entities.ServicioValoracion;
import com.microservices.servicioapp.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/servicios/valoraciones")
public class ValoracionController {
    @Autowired
    private ValoracionService valoracionService;

    @GetMapping(path = "/")
    public ResponseEntity<List<ServicioValoracion>> obtenerValoraciones() {
        final ResponseEntity<List<ServicioValoracion>> response = new ResponseEntity<List<ServicioValoracion>>(valoracionService.getValoracionesList(), HttpStatus.OK);
        return response;
    }

    @PostMapping(path = "/nueva")
    public ResponseEntity<ServicioValoracion> guardarValoracionSobreServicio(@RequestBody() ServicioValoracion servicioValoracion) {
        final ResponseEntity<ServicioValoracion> response = new ResponseEntity<ServicioValoracion>(valoracionService.saveValoracion(servicioValoracion), HttpStatus.CREATED);
        return response;
    }
}
