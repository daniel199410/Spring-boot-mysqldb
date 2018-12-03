package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Queries;
import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.repository.QueriesRepository;
import com.example.springbootmysqldb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/query")
public class QueriesController {

    @Autowired
    private QueriesRepository queriesRepository;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/{userId}")
    public Users createQuery(@PathVariable("userId") Long userId, @RequestBody List<Queries> query) {
        Users user = usersRepository.findById(userId).get();
        user.setQueries(query);
        return usersRepository.save(user);
    }

}
