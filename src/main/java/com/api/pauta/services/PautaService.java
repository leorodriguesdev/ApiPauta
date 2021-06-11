package com.api.pauta.services;

import com.api.pauta.repository.PautaRepository;
import com.api.pauta.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

        PautaRepository repository;
        UsersRepository usersRepository;

    @Autowired
    public PautaService(PautaRepository repository, UsersRepository usersRepository) {
            this.repository = repository;
            this.usersRepository = usersRepository;
        }
}


