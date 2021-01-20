package com.example.ContactsApp.repository;

import com.example.ContactsApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    
}
