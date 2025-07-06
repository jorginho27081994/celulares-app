package com.celulares.serviciocelulares.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
}