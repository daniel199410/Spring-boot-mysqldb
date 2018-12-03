package com.example.springbootmysqldb.repository;

import com.example.springbootmysqldb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UsersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
}
