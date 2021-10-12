package com.callosmattos.contacts_book.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callosmattos.contacts_book.dtos.PersonDTO;
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
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll() {
		List<Person> list = service.findAll();
		List<PersonDTO> listDTO = list.stream().map(obj -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
