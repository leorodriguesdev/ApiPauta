package com.api.pauta.services;


import com.api.pauta.entities.Users;
import com.api.pauta.repository.UsersRepository;
import com.api.pauta.services.exception.NuloPointerException;
import com.api.pauta.services.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public Users saveService(Users user) {
        if (user.getName().isEmpty()) {
            throw new ValidationException("Nome é obrigatório");
        }
        return repository.save(user);
    }

    public List<Users> findAll() {
        List<Users> list = repository.findAll();
        if (list.isEmpty()) {
            throw new ValidationException("Nenhum usuário cadastrado");
        }
        return list;
    }

    private Optional<Users> findByIdService(Long id) {
        Optional<Users> userOpt = repository.findById(id);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Informe um ID válido");
        }
        return userOpt;
    }

    private Optional<Users> findByNameService(String name) {
        Optional<Users> userOpt = repository.findByName(name);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Informe um Nome válido");
        }
        return userOpt;
    }

    private Optional<Users> findByNameAndIdService(String name, Long id) {
        Optional<Users> userOpt = repository.findByNameAndId(name, id);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        return userOpt;
    }

    public Optional<Users> findUserService(String name, Long id) {

        if (id == null && name == null) {
            throw new NuloPointerException("Informe um ID e/ou Nome");
        }
        if (id == null) {
            return findByNameService(name);
        } else if (name == null) {
            return findByIdService(id);
        } else {
            return findByNameAndIdService(name, id);

        }
    }
}

//    public void delete(Long id) {
//        repository.delete(id);
//    }


/*
 * Criar a entidade da pauta > criar o repo,serv e controller > CRUD
 *
 *
 *
 * */

