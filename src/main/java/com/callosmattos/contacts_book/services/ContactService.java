package com.callosmattos.contacts_book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callosmattos.contacts_book.models.Contact;
import com.callosmattos.contacts_book.models.Person;
import com.callosmattos.contacts_book.services.exceptions.ObjectNotFoundException;
import com.carllosmattos.contacts_book.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private PersonService personService;
	
	public Contact findById(Long id) {
		Optional<Contact> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contact.class.getName()));
	}

	public List<Contact> findAll(Long person_id) {
		personService.findById(person_id);
		return repository.findAllByPerson(person_id);
	}

	public Contact update(Long id, Contact obj) {
		Contact newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Contact newObj, Contact obj) {
		newObj.setValor(obj.getValor());
		newObj.setTipo_contato(obj.getTipo_contato());
	}

	public Contact create(Long person_id, Contact obj) {
		obj.setId(null);
		Person ps = personService.findById(person_id);
		obj.setPerson(ps);
		return repository.save(obj);
	}

	public void delete(Long id) {
		Contact obj = findById(id);
		repository.delete(obj);
	}
}
