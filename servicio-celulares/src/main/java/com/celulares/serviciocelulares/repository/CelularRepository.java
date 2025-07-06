package com.celulares.serviciocelulares.repository;

import com.celulares.serviciocelulares.model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelularRepository extends JpaRepository<Celular, Long> {}