package com.callosmattos.contacts_book.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.callosmattos.contacts_book.dtos.ContactDTO;
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
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> findAll(@RequestParam(value = "person", defaultValue = "0") Long person_id) {
		List<Contact> list = service.findAll(person_id);
		List<ContactDTO> listDTO = list.stream().map(obj -> new ContactDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact obj) {
		Contact newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Contact> updatePatch(@PathVariable Long id, @RequestBody Contact obj) {
		Contact newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Contact> create(@RequestParam(value = "person", defaultValue = "0") Long person_id, @RequestBody Contact obj) {
		Contact newObj = service.create(person_id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/contacts/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
