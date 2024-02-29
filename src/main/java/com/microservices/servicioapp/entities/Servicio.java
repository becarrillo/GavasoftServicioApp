package com.microservices.servicioapp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.util.List;

/**
 * @author Brando Elí Carrillo Pérez
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "servicio_id")
    private String servicioId;

    @Column(name = "servicio_nombre")
    private String servicioNombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion")
    private Time duracion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "img_url")
    private String imgUrl;

    public Servicio(
            String servicioNombre,
            String descripcion,
            Time duracion,
            Integer precio,
            String imgUrl
    ) {
        this.servicioNombre = servicioNombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.imgUrl = imgUrl;
    }
}
