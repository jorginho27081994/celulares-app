package com.celulares.serviciologin.controller;

import com.celulares.serviciologin.model.Usuario;
import com.celulares.serviciologin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario u) {
        return ResponseEntity.ok(service.registrar(u));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String password = datos.get("password");
        boolean acceso = service.login(correo, password);
        if (acceso) {
            return ResponseEntity.ok("Acceso permitido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}