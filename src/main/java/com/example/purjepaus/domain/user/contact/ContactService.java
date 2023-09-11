package com.example.purjepaus.domain.user.contact;

import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public Contact getContactInfoBy(Integer contactId) {
        return contactRepository.getReferenceById(contactId);
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }
}
