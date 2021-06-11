package com.api.pauta.repository;

import com.api.pauta.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long> {

    @Override
    public Optional<Users> findById(Long id);
    public Optional<Users> findByName(String name);
    public Optional<Users> findByNameAndId(String name,Long id);
    public void delete(Long id);
}

