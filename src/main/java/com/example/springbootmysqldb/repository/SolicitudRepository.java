package com.example.springbootmysqldb.repository;

import com.example.springbootmysqldb.model.Solicitud;
import com.example.springbootmysqldb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByUser(Users user);
}
