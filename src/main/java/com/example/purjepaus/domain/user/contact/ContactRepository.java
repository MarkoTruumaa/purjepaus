package com.example.purjepaus.domain.user.contact;

import com.example.purjepaus.domain.user.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}