package com.callosmattos.contacts_book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callosmattos.contacts_book.models.Contact;
import com.callosmattos.contacts_book.services.exceptions.ObjectNotFoundException;
import com.carllosmattos.contacts_book.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repository;
	
	public Contact findById(Long id) {
		Optional<Contact> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contact.class.getName()));
	}
}