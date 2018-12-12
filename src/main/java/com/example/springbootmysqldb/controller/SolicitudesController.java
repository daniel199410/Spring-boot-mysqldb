package com.example.springbootmysqldb.controller;

import com.example.springbootmysqldb.model.Solicitud;
import com.example.springbootmysqldb.model.Usuario;
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
    public Solicitud createQuery(@PathVariable("userId") Long codigoUsuario, @RequestBody Solicitud solicitud) {
        Usuario usuario = usersRepository.findById(codigoUsuario).get();
        solicitud.setUsuario(usuario);
        return solicitudRepository.save(solicitud);
    }

    @GetMapping("/{userId}")
    public List<Solicitud> getSolicitud(@PathVariable("userId") Long userId) {
        return solicitudRepository.findByUsuario(usersRepository.findById(userId).get());
    }
}
