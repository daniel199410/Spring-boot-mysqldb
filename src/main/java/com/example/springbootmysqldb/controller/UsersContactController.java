package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.model.UsersContact;
import com.example.springbootmysqldb.repository.UsersContactRepository;
import com.example.springbootmysqldb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactController {

    @Autowired
    private UsersContactRepository usersContactRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/{user_id}")
    public UsersContact getUsersContact(@PathVariable("user_id") long user_id) {
        return usersRepository.findById(user_id).get().getUsersContact();
    }

    @PostMapping("/{user_id}")
    public Users createUsersContact(@PathVariable("user_id") long user_id, @RequestBody UsersContact usersContact) {
        Users users = usersRepository.findById(user_id).get();
        users.setUsersContact(usersContact);
        return usersRepository.save(users);
    }

}
