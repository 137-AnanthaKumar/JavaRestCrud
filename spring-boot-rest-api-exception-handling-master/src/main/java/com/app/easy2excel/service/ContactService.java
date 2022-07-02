package com.app.easy2excel.service;

import com.app.easy2excel.dto.ContactDTO;
import com.app.easy2excel.entity.Contact;
import com.app.easy2excel.exception.RecordNotFoundException;
import com.app.easy2excel.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public ContactDTO saveContact(ContactDTO contactDTO){

        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNo(contactDTO.getPhoneNo());
        Contact contactDB= contactRepository.save(contact);
        return from(contactDB);
    }
    public Contact getContactById(Long id){
    	
        return  contactRepository.findById(id)
        		.orElseThrow(() -> new RecordNotFoundException("Employee not exist with id :" + id));


    }

    private  ContactDTO from(Contact contact){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setPhoneNo(contact.getPhoneNo());
        return contactDTO ;
    }

    public boolean isEmailPresent(String email){

        Contact contact =    contactRepository.findByEmail(email);
        if(null==contact){
            return true;
        }else{
            return false;
        }

    }

}
