package com.api.pauta.controller;

import com.api.pauta.entities.Pautas;
import com.api.pauta.services.PautaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    private PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }


    @GetMapping
    @ApiOperation("Informa todas as pautas existentes.")
    public ResponseEntity<List<Pautas>> findAllPauta() {
        return ResponseEntity.ok(pautaService.findAll());
    }

    @PostMapping
    @ApiOperation("Inseri uma nova pauta.")
    public ResponseEntity<Pautas> savePauta(@RequestBody Pautas pauta) {

        return ResponseEntity.ok(pautaService.saveService(pauta));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma nova pauta.")
    public ResponseEntity<Pautas> updateUser(@RequestBody Pautas pauta, @PathVariable Long id) {
        pauta.setId(id);
        return ResponseEntity.ok(pautaService.saveService(pauta));
    }

    @GetMapping("/findpauta")
    @ApiOperation("Busca Pauta por Id ou Tema.")
    public ResponseEntity<Optional<Pautas>> findPautaController(@RequestParam(name = "theme", required = false) String theme, @RequestParam(name = "id", required = false) Long id) {

        return ResponseEntity.ok(pautaService.findPautaService(theme, id));

    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta a Pauta por ID.")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        boolean ok = pautaService.delete(id);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}


