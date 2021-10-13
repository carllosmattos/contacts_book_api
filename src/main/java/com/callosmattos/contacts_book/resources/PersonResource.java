package com.callosmattos.contacts_book.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.callosmattos.contacts_book.dtos.PersonDTO;
import com.callosmattos.contacts_book.models.Person;
import com.callosmattos.contacts_book.services.PersonService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/persons")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		Person obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	};
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll() {
		List<Person> list = service.findAll();
		List<PersonDTO> listDTO = list.stream().map(obj -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Person> create(@Valid @RequestBody Person obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> update(@Valid @PathVariable Long id, @RequestBody PersonDTO objDto) {
		Person newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new PersonDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
