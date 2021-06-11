package com.api.pauta.controller;

import com.api.pauta.entities.Users;
import com.api.pauta.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    public UsersService service;

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users users){

        return ResponseEntity.ok(service.saveService(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Long id){
        user.setId(id);
        return ResponseEntity.ok(service.saveService(user));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Users> delete(@PathVariable Long id){
//            service.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping
    public ResponseEntity<List<Users>> findAllUser() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/finduser")
    public ResponseEntity<Optional<Users>> findUserController(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "id", required = false) Long id) {

        return ResponseEntity.ok(service.findUserService(name, id));

    }
}
