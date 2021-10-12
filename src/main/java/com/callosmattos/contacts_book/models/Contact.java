package com.callosmattos.contacts_book.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "valor")
	private String valor;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_contato")
	private ContactType tipo_contato;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public Contact() {
		super();
	}

	public Contact(Integer id, String valor, ContactType tipo_contato, Person person) {
		super();
		this.id = id;
		this.valor = valor;
		this.tipo_contato = tipo_contato;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ContactType getTipo_contato() {
		return tipo_contato;
	}

	public void setTipo_contato(ContactType tipo_contato) {
		this.tipo_contato = tipo_contato;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Contact other = (Contact) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
