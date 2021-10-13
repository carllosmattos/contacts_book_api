package com.callosmattos.contacts_book.models;

import com.callosmattos.contacts_book.services.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum ContactType {
	EMAIL("EMAIL"),
	TELEFONE("TELEFONE"),
	CELULAR("CELULAR");

    private final String type;

	ContactType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

    @JsonCreator
    public static ContactType create (String value) throws EnumValidationException {
        if(value == null) {
            throw new EnumValidationException(value, "ContactType");
        }
        for(ContactType v : values()) {
            if(value.equals(v.getType())) {
                return v;
            }
        }
        throw new EnumValidationException(value, "ContactType");
    }
}
