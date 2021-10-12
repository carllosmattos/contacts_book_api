package com.callosmattos.contacts_book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callosmattos.contacts_book.dtos.PersonDTO;
import com.callosmattos.contacts_book.models.Person;
import com.callosmattos.contacts_book.services.exceptions.DataIntegrityViolationException;
import com.callosmattos.contacts_book.services.exceptions.ObjectNotFoundException;
import com.carllosmattos.contacts_book.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repository;
	
	public Person findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Person.class.getName()));
	}
	
	public List<Person> findAll() {
		return (List<Person>) repository.findAll();
	}
	
	public Person create (Person obj) {
		obj.setId(0);
		return repository.save(obj);
	}

	public Person update(Long id, PersonDTO objDto) {
		Person obj = findById(id);
		obj.setName(objDto.getName());
		obj.setSurname(objDto.getSurname());
		obj.setCpf(objDto.getCpf());
		obj.setBirthday(objDto.getBirthday());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Esta pessoa não pode ser deletada! A mesma possui contatos salvos!");
		}
	}
}
