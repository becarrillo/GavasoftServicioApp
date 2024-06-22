package com.microservices.servicioapp.entities;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Brando Elí Carrillo Pérez
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "valoraciones_de_servicios")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Unsigned
    @Column(name = "valoracion_id")
    private String valoracionId;

    @Column(name = "puntuacion")
    private byte puntuacion;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "servicio_id")
    private String servicioId;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Valoracion(
            byte puntuacion
    ) {
        this.puntuacion = puntuacion;
    }

    public Valoracion(
            byte puntuacion,
            String opinion
    ) {
        this.puntuacion = puntuacion;
        this.opinion = opinion;
    }
}
