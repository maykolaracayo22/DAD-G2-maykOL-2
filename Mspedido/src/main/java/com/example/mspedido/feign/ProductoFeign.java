package com.example.mspedido.feign;

import com.example.mspedido.dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "mscatalogo-service", path = "/producto")

public interface ProductoFeign {
    @GetMapping("/{id}")

    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallBackProducto")
    public ResponseEntity<ProductoDto> BuscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<ProductoDto> fallBackProducto(Integer id, Exception e) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(400000);
        return ResponseEntity.ok(productoDto);
    }


}


















