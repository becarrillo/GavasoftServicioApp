package com.microservices.servicioapp.entities;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * @author Brando Elí Carrillo Pérez
 */
@Entity
@Table(name = "valoraciones_servicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServicioValoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Unsigned
    @Column(name = "valoracion_id")
    private int valoracionId;

    @Column(name = "puntuacion")
    private byte puntuacion;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "servicio_id")
    private String servicioId;
}
