package com.api.pauta.controller;

import com.api.pauta.entities.Users;
import com.api.pauta.services.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    public UsersService service;

    @PostMapping
    @ApiOperation("Inseri um novo usuário/associado.")
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {

        return ResponseEntity.ok(service.saveService(users));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um usuário/associado.")
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Long id) {
        user.setId(id);
        return ResponseEntity.ok(service.saveService(user));
    }

    @GetMapping
    @ApiOperation("Informa todos os usuários/associados existentes.")
    public ResponseEntity<List<Users>> findAllUser() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/finduser")
    @ApiOperation("Busca usuário/associado por Id ou Tema.")
    public ResponseEntity<Optional<Users>> findUserController(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "id", required = false) Long id) {

        return ResponseEntity.ok(service.findUserService(name, id));

    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta a usuário/associado por ID.")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        boolean ok = service.delete(id);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
