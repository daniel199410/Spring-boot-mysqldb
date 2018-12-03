package com.example.springbootmysqldb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsersContact {
    @Id
    @GeneratedValue
    private long id;
    private String phone;

    public UsersContact() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
