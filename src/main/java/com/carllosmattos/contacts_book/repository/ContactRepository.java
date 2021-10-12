package com.carllosmattos.contacts_book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.callosmattos.contacts_book.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Query(value = "SELECT obj FROM Contact obj WHERE obj.person.id = :person_id ORDER BY valor")
	List<Contact> findAllByPerson(@Param(value = "person_id") Long person_id);

}
