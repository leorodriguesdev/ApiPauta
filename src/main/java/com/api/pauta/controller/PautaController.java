package com.api.pauta.controller;

import com.api.pauta.services.PautaService;
import com.api.pauta.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {
    private PautaService pautaService;
    private UsersService associadoService;

    @Autowired
    public PautaController(PautaService pautaService, UsersService associadoService) {
        this.pautaService = pautaService;
        this.associadoService = associadoService;
    }
}

