package com.example.ContactsApp.service;

import com.example.ContactsApp.model.Contact;
import com.example.ContactsApp.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repo;
    
    //using Spring Data JPA to inherit findAll() from CrudRepository
    public List<Contact> listAll() {
        return repo.findAll();
    }
    
    public void create(Contact contact) {
        repo.save(contact);
    }
    
    public Contact updateid(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    //implementing the searching functionality from the repository
    public List<Contact> findByKeyword(String keyword) {
        return repo.findByKeyword(keyword);
    }    
}
