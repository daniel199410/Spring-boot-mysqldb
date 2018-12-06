package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.repository.UsersRepository;
import com.example.springbootmysqldb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "rest/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUser(@PathVariable("id") Long id) {
        if(userService.isAuthorized(id)) {
            return usersRepository.findById(id);
        }
        return null;
    }

    @PostMapping("create")
    public Users save(@RequestBody final Users user) {
        return usersRepository.save(user);
    }

    @GetMapping("/test")
    public String test(){
        return "works";
    }
}
