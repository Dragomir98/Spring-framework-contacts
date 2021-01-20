package com.example.ContactsApp.repository;

import com.example.ContactsApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJPaRepo extends JpaRepository<User, Long>{
    
}
