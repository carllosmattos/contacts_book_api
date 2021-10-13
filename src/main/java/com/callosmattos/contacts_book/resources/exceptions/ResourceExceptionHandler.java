package com.callosmattos.contacts_book.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;

import com.callosmattos.contacts_book.dtos.ValidationErrorDTO;
import com.callosmattos.contacts_book.services.exceptions.DataIntegrityViolationException;
import com.callosmattos.contacts_book.services.exceptions.EnumValidationException;
import com.callosmattos.contacts_book.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFounException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ValidationErrorDTO> processValidationIllegalError(HttpMessageNotReadableException ex,
            HandlerMethod handlerMethod, WebRequest webRequest) {

        EnumValidationException exception = (EnumValidationException) ex.getMostSpecificCause();

        ValidationErrorDTO errorDTO = new ValidationErrorDTO();
        errorDTO.setEnumName(exception.getEnumName());
        errorDTO.setEnumValue(exception.getEnumValue());
        errorDTO.setErrorMessage(exception.getEnumValue() + " is an invalid " + exception.getEnumName());
        return new ResponseEntity<ValidationErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
