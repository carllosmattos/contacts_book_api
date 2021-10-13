package com.callosmattos.contacts_book.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.callosmattos.contacts_book.models.Person;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
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
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(Person obj) {
		super();
		this.id = (int) obj.getId();
		this.name = obj.getName();
		this.surname = obj.getSurname();
		this.cpf = obj.getCpf();
		this.birthday = obj.getBirthday();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	
}
