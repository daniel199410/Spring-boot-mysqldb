package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Solicitud;
import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.repository.SolicitudRepository;
import com.example.springbootmysqldb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/solicitud")
public class SolicitudesController {

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/{userId}")
    public Users createQuery(@PathVariable("userId") Long userId, @RequestBody List<Solicitud> query) {
        Users user = usersRepository.findById(userId).get();
        user.setSolicitudes(query);
        return usersRepository.save(user);
    }

    @GetMapping("/{userId}")
    public List<Solicitud> getSolicitud(@PathVariable("userId") Long userId) {
        return solicitudRepository.findByUser(usersRepository.findById(userId).get());
    }
}
