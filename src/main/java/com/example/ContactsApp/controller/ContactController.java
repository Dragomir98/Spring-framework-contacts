package com.example.ContactsApp.controller;

import com.example.ContactsApp.model.Contact;
import com.example.ContactsApp.service.ContactService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

@Controller
public class ContactController {
    
    @Autowired
    private ContactService service;
    
    @RequestMapping("/")
    public String viewIndexPage(Model model, String keyword) {
        List<Contact> contactList = service.listAll();
        
        if(keyword != null) {
            //implementing the search functionality in the controller and set the entered keyword as parameter
            model.addAttribute("getAllContacts", service.findByKeyword(keyword));
        }
        else {
            model.addAttribute("getAllContacts", contactList);
        }
        return "index";
    }
    
    @RequestMapping("/add_new")
    public String viewNewContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "insert";
    }
    
    @RequestMapping(value = "/save_contact", method = RequestMethod.POST)
    public String addNewContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "insert";
        }
        else {
            service.create(contact);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditContactForm(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("update");
        Contact contact = service.updateid(id);
        mav.addObject("contact", contact);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteContact(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }
}
