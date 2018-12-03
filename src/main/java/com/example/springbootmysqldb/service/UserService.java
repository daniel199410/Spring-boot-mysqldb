package com.example.springbootmysqldb.service;

import com.example.springbootmysqldb.model.Users;
import com.example.springbootmysqldb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(username);
        return new User(user.getUserName(), user.getPassword(), user.isActive(), user.isActive(), user.isActive(), user.isActive(), buildGranted(user.getRol()));
    }

    public List<GrantedAuthority> buildGranted(byte rol) {
        String[] roles = {"READER", "USER", "ADMINISTRATOR"};
        List<GrantedAuthority> auths = new ArrayList<>();
        for(int i = 0; i < rol; i++) {
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }

    public boolean isAuthorized(Long id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByUserName(userName);
        return user.getId() == id;
    }
}
