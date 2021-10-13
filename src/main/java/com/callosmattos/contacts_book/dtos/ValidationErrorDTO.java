package com.callosmattos.contacts_book.dtos;

public class ValidationErrorDTO {

	private String enumValue;
	private String enumName;
	private String errorMessage;
	
	public ValidationErrorDTO() {
		super();
	}

	public ValidationErrorDTO(String enumValue, String enumName, String errorMessage) {
		super();
		this.enumValue = enumValue;
		this.enumName = enumName;
		this.errorMessage = errorMessage;
	}

	public String getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
