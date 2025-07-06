package com.celulares.serviciocelulares.service;

import com.celulares.serviciocelulares.model.Celular;
import com.celulares.serviciocelulares.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {

    @Autowired
    private CelularRepository repo;

    public List<Celular> listar() {
        return repo.findAll();
    }

    public Celular guardar(Celular c) {
        return repo.save(c);
    }

    public Optional<Celular> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Celular actualizar(Long id, Celular c) {
        c.setId(id);
        return repo.save(c);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
