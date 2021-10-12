package com.callosmattos.contacts_book.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callosmattos.contacts_book.models.Person;
import com.callosmattos.contacts_book.services.PersonService;

@RestController
@RequestMapping(value="/persons")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Person> findById(@PathVariable Integer id){
		Person obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	};
	
}
