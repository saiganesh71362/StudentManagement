package com.stude.globalexceptionhandle;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionMesseage> handleNotFoundException(NotFoundException notFoundException,
			WebRequest webRequest) {
		ExceptionMesseage message = new ExceptionMesseage(new Date(), notFoundException.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<ExceptionMesseage>(message, HttpStatus.OK);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ExceptionMesseage> handleIdNotFoundException(IdNotFoundException idNotFoundException,
			WebRequest webRequest) {

		ExceptionMesseage message = new ExceptionMesseage(new Date(), idNotFoundException.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<ExceptionMesseage>(message, HttpStatus.OK);
	}

}
