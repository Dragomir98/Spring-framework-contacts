package com.example.ContactsApp.service;

import com.example.ContactsApp.model.Role;
import com.example.ContactsApp.model.User;
import com.example.ContactsApp.repository.RoleRepository;
import com.example.ContactsApp.repository.UserJPaRepo;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserJPaRepo repo;
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //use save() to create or update contacts
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.getOne(2));
        user.setRoles(roles);
        repo.save(user);
    }

}
