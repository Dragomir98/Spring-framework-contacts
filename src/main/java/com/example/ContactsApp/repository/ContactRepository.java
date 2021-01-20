package com.example.ContactsApp.repository;

import com.example.ContactsApp.model.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
        
    //Query to get the data from the database
    @Query(value="select * from contacts c where c.id like %:keyword% or "
            + "c.first_name like %:keyword% "
            + "or c.last_name like %:keyword% "
            + "or c.email like %:keyword% "
            + "or c.phone_num like %:keyword% "
            + "or c.description like %:keyword% ", nativeQuery=true)
    List<Contact> findByKeyword(@Param("keyword") String keyword);//declaring the searching functionality
}
