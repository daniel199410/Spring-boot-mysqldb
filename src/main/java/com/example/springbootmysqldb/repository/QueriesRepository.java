package com.example.springbootmysqldb.repository;

import com.example.springbootmysqldb.model.Queries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueriesRepository extends JpaRepository<Queries, Long> {
}
