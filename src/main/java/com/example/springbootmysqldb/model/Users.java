package com.example.springbootmysqldb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(name = "team_name")
    private String teamName;
    private int salary;
    private String userName;
    private String password;
    private boolean isActive;
    private byte rol;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UsersContact usersContact;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Queries> queries;

    public Users(long user_id) {
        this.id = user_id;
    }

    public Users() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UsersContact getUsersContact() {
        return usersContact;
    }

    public void setUsersContact(UsersContact usersContact) {
        this.usersContact = usersContact;
    }

    public List<Queries> getQueries() {
        return queries;
    }

    public void setQueries(List<Queries> queries) {
        for(Queries query: queries) {
            this.queries.add(query);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }
}
