package com.kpilszak.todoapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = IllegalExceptionProcessing.class)
class IllegalExceptionsControllerAdvice {
	
	@ExceptionHandler(IllegalArgumentException.class)
	ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(IllegalStateException.class)
	ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
