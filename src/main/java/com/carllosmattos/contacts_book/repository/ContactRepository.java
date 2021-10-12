package com.carllosmattos.contacts_book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.callosmattos.contacts_book.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
