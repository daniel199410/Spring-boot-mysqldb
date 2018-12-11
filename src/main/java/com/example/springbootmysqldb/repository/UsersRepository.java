package com.example.springbootmysqldb.repository;

import com.example.springbootmysqldb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UsersRepository")
public interface UsersRepository extends JpaRepository<Usuario, Long> {
    Usuario findByDocumento(String documento);
}
