package com.microservices.servicioapp.controller;

import com.microservices.servicioapp.entities.Servicio;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("http://usuario-app.railway.internal:8081")
@RestController
@RequestMapping(path = "/v1/servicios")
public class ServicioController {

    @Autowired
    private com.microservices.servicioapp.services.ServicioService servicioService;

    @PostMapping(path = "/agregar/nuevo")
    public Servicio agregarServicio(@RequestBody Servicio servicio) {
        log.info("Se agregó un servicio con éxito: '{}'", servicio.toString());
        final Servicio newServicio = servicioService.save(servicio);
        return newServicio;
    }

    @GetMapping(path = "/consultar-por-nombre/{name}")
    public Servicio consultarServicio(@PathVariable("name") String servicioNombre) {
        return servicioService.getOne(servicioNombre);
    }

    @GetMapping(path = "/{servicioId}")
    public Servicio consultarServicioPorId(@PathVariable String servicioId) {
        return servicioService.getOneById(servicioId);
    }

    @GetMapping(path = "/{servicioId}/precio")
    public Integer obtenerPrecioxServicioId(@PathVariable("servicioId") String id) {
        return servicioService.getOneById(id).getPrecio();
    }

    @GetMapping
    public List<Servicio> listarServicios() {
        return servicioService.getAll();
    }

    @PostMapping("/{name}/modificar")
    public Servicio modificarServicio(@PathVariable("name") String servicioNombre, @RequestBody() Servicio servicio) {
        // Primero está incluída la funcionalidad consulta del Servicio para poder modificarlo
        final Servicio foundServicio = servicioService.getOne(servicioNombre);

        if (foundServicio != null) {
            return servicioService.updateOne(foundServicio, servicio);
        }
        return null;
    }

    @GetMapping(path = "/{servicioId}/eliminar")
    public String eliminarServicio(@PathVariable("servicioId") String id) {
        // Primero está incluída la funcionalidad consulta del Servicio para poder eliminarlo
        final Servicio foundServicio = servicioService.getOneById(id);

        if (foundServicio != null) {
            return servicioService.delete(id);
        }
        return null;
    }

    /* @CircuitBreaker(name = "LISTENER", fallbackMethod = "listenerFallback")
    @RabbitListener(queues = {"${mcsv.rabbit.default.queue.name}"})
	public void receiveMessage(@Payload String message) {
        final List<String> split = Arrays.stream(message.split("::")).toList();

        switch (split.get(0)) {
            case "Agregar Servicio":
                String bodyCadena = split.get(1);
                bodyCadena = bodyCadena.replace(']', ' ');

                if (bodyCadena.startsWith("[")) {
                    bodyCadena = bodyCadena.replace('[', ' ');
                }
                bodyCadena = bodyCadena.trim();

                List<String> l = Arrays.stream(bodyCadena.split(",")).toList();

                TimeZone.setDefault(TimeZone.getTimeZone("GMT-5:00"));

                final Servicio servicio = new Servicio(
                        l.get(0),
                        l.get(1),
                        Time.valueOf(LocalTime.parse(l.get(2))),
                        Integer.parseInt(l.get(3)),
                        l.get(4)
                );
                
                log.info("Servicio guardado: '{}'", servicioService.save(servicio).toString());
                break;
            case "Consultar Servicio":
                servicioService.setFoundServicio(servicioService.getOne(split.get(1)));

                log.info("Servicio encontrado: '{}'", servicioService.getFoundServicio());
        }
	}

    public ResponseEntity<String> listenerFallback(Exception e) {
        log.info("El respaldo se ejecuta porque la solicitud sobre Servicio falló: '{}'", e);
        return new ResponseEntity<String>("Un respaldo a fallo se ha ejecutado", HttpStatus.OK);
    }
     */
}
