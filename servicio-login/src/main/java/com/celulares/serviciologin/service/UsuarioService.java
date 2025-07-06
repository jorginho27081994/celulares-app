package com.celulares.serviciologin.service;

import com.celulares.serviciologin.model.Usuario;
import com.celulares.serviciologin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario registrar(Usuario u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public boolean login(String correo, String password) {
        Optional<Usuario> opt = repo.findByCorreo(correo);
        return opt.isPresent() && encoder.matches(password, opt.get().getPassword());
    }
}