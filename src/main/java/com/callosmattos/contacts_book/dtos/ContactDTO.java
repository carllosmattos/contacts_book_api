package com.callosmattos.contacts_book.dtos;

import java.io.Serializable;

import com.callosmattos.contacts_book.models.Contact;
import com.callosmattos.contacts_book.models.ContactType;

public class ContactDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String valor;
	private ContactType tipo_contato;

	public ContactDTO() {
		super();
	}

	public ContactDTO(Contact obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.tipo_contato = obj.getTipo_contato();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	
}
