package com.api.pauta.repository;

import com.api.pauta.entities.Pautas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PautaRepository extends JpaRepository<Pautas, Long> {

    @Override
    public Optional<Pautas> findById(Long id);

    public Optional<Pautas> findByTheme(String theme);

    public Optional<Pautas> findByThemeAndId(String theme, Long id);
}
