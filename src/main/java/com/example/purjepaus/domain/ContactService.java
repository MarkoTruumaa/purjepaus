package com.example.purjepaus.domain;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public Contact getContactInfoBy(Integer contactId) {
        return contactRepository.getReferenceById(contactId);
    }
}
