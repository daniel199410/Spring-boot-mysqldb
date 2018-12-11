package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Usuario;
import com.example.springbootmysqldb.repository.UsersRepository;
import com.example.springbootmysqldb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "rest/usuarios")
public class UsuarioController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/todos")
    public List<Usuario> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") Long id) {
        if(userService.isAuthorized(id)) {
            return usersRepository.findById(id);
        }
        return null;
    }

    @PostMapping("crear")
    public Usuario save(@RequestBody final Usuario usuario) {
        return usersRepository.save(usuario);
    }

    @GetMapping(value = "/test", produces = "application/json")
    public Map<String, String> test(){
        return Collections.singletonMap("response", "works");
    }
}
