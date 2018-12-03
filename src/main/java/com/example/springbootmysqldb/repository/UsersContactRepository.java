package com.example.springbootmysqldb.repository;

import com.example.springbootmysqldb.model.UsersContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersContactRepository extends JpaRepository<UsersContact, Long> {

}
