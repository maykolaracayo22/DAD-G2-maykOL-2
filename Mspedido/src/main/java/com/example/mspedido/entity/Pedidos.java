package com.example.mspedido.entity;


import com.example.mspedido.dto.ClienteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clienteid;
    private LocalDate fecha;
    private String cliente;
    private String estado;
    private BigDecimal total;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<Pedidodetalle> detalle;

    @Transient
    private ClienteDto clienteDto ;
}
