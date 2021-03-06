package com.callosmattos.contacts_book.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@NotEmpty(message = "Campo Nome é requerido!")
	@Length(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres!")
	private String name;
	
	@NotEmpty(message = "Campo Sobrenome é requerido!")
	@Length(min = 3, max = 100, message = "O campo Sobrenome deve ter entre 3 e 100 caracteres!")
	private String surname;
	
	@NotEmpty(message = "Campo CPF é requerido!")
	@Length(min = 11, max = 11, message = "O campo CPF deve ter 11 caracteres!")
	private String cpf;
	
	@NotEmpty(message = "Campo Data é requerido!")
	@Length(min = 10, max = 10, message = "O campo Data deve ter 11 caracteres!")
	private String birthday;

	@OneToMany(mappedBy = "person")
	@Cascade({CascadeType.REMOVE})
	private List<Contact> contacts = new ArrayList<>();

	public Person() {
		super();
	}

	public Person(Long id, String name, String surname, String cpf, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = (Long) id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
