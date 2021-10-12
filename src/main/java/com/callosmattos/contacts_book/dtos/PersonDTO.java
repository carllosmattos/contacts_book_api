package com.callosmattos.contacts_book.dtos;

import java.io.Serializable;

import com.callosmattos.contacts_book.models.Person;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String surname;
	private String cpf;
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
