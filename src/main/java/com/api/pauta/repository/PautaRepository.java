package com.api.pauta.repository;

import com.api.pauta.entities.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    @Override
    public Optional<Pauta> findById(Long id);
    public Optional<Pauta> findByTheme(String name);
    public Optional<Pauta> findByThemeAndId(String name,Long id);
//    public void delete(Long id);
}
