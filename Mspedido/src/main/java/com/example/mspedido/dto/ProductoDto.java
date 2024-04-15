package com.example.mspedido.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductoDto {
    private Integer id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private LocalDate fecha_creacion;


}
