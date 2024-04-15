package com.example.mspedido.entity;


import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Pedidodetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreproducto;
    private Double cantidad;
    private Double precio;
    private Integer productoid;
    

    @Transient
    private ProductoDto productoDto;
    public Pedidodetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

}
