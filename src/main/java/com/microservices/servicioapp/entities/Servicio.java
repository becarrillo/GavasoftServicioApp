package com.microservices.servicioapp.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private short duracion;

    @Column(name = "precio")
    private int precio;

    @Column(name = "img_url")
    private String imgUrl;

    public Servicio(
            String servicioNombre,
            String descripcion,
            short duracion,
            int precio,
            String imgUrl
    ) {
        this.servicioNombre = servicioNombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.imgUrl = imgUrl;
    }
}
