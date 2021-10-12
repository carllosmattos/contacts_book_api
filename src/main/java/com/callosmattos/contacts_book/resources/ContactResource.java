package com.callosmattos.contacts_book.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callosmattos.contacts_book.models.Contact;
import com.callosmattos.contacts_book.services.ContactService;

@RestController
@RequestMapping(value = "/contacts")
public class ContactResource {
	
	@Autowired
	private ContactService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id) {
		Contact obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
