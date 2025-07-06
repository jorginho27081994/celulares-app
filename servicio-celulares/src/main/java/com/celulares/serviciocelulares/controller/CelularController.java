package com.celulares.serviciocelulares.controller;

import com.celulares.serviciocelulares.model.Celular;
import com.celulares.serviciocelulares.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/celulares")
public class CelularController {

    @Autowired
    private CelularService service;

    @GetMapping
    public List<Celular> listar() {
        return service.listar();
    }

    @PostMapping
    public Celular guardar(@RequestBody Celular c) {
        return service.guardar(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Celular> buscarPorId(@PathVariable Long id) {
        Optional<Celular> celular = service.buscarPorId(id);
        return celular.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Celular> actualizar(@PathVariable Long id, @RequestBody Celular c) {
        return ResponseEntity.ok(service.actualizar(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}