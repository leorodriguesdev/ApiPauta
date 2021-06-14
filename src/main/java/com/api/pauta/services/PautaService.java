package com.api.pauta.services;

import com.api.pauta.entities.Pautas;
import com.api.pauta.entities.Users;
import com.api.pauta.repository.PautaRepository;
import com.api.pauta.services.exception.NuloPointerException;
import com.api.pauta.services.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class PautaService {

    PautaRepository pautaRepository;
    UsersService usersService;


    public PautaService(PautaRepository pautaRepository, UsersService usersService) {
        this.pautaRepository = pautaRepository;
        this.usersService = usersService;
    }

    public List<Pautas> findAll() {
        List<Pautas> list = pautaRepository.findAll();
        if (list.isEmpty()) {
            throw new ValidationException("Nenhum usuário cadastrado");
        }
        return list;
    }

    public Pautas voto(Long idPalta, Long idUser) {
        Optional<Users> userOpt = usersService.findUserService(null, idUser);
        Optional<Pautas> pautaOpt = pautaRepository.findById(idPalta);

        return pautaOpt.get();
    }

    public Pautas saveService(Pautas pauta) {
        if (pauta.getTheme().isEmpty()) {
            throw new ValidationException("Nome é obrigatório");
        }
        return pautaRepository.save(pauta);
    }

    public boolean delete(Long id) {
        if (findByIdService(id).isPresent()) {
            pautaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Optional<Pautas> findByIdService(Long id) {
        Optional<Pautas> userOpt = pautaRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Informe um ID válido");
        }
        return userOpt;
    }

    private Optional<Pautas> findByThemeService(String name) {
        Optional<Pautas> userOpt = pautaRepository.findByTheme(name);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Informe um Nome válido");
        }
        return userOpt;
    }


    private Optional<Pautas> findByThemeAndIdService(String theme, Long id) {
        Optional<Pautas> userOpt = pautaRepository.findByThemeAndId(theme, id);
        if (userOpt.isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        return userOpt;
    }

    public Optional<Pautas> findPautaService(String theme, Long id) {

        if (id == null && theme == null) {
            throw new NuloPointerException("Informe um ID e/ou Nome");
        }
        if (id == null) {
            return findByThemeService(theme);
        } else if (theme == null) {
            return findByIdService(id);
        } else {
            return findByThemeAndIdService(theme, id);

        }
    }

}


