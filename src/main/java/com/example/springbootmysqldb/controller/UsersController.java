package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "rest/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUser(@PathVariable("id") Long id) {
        return usersRepository.findById(id);
    }

    @PostMapping("create")
    public Users save(@RequestBody final Users user) {
        return usersRepository.save(user);
    }
}
