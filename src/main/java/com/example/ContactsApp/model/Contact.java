package com.example.ContactsApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "contacts") 
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Size(min = 2, message = "First name must be atleast 2 letters long!")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, message = "Last name must be atleast 2 letters long!")
    @Column(name = "last_name")
    private String lastName;
    
    @Email(message = "Must be well formed like email@email.com")
    @Column(name = "email")
    private String email;
    
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 numbers")
    @Column(name = "phone_num")
    private String phoneNum;
    
    @Size(max = 50, message = "Description can't be more than 50 characters")
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
