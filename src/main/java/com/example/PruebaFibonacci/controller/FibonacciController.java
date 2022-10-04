package com.example.PruebaFibonacci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PruebaFibonacci.DTO.FibonacciDTO;
import com.example.PruebaFibonacci.service.FibonacciService;

@RestController
@RequestMapping("/fibonacci/calculator")
public class FibonacciController {

	private final FibonacciService service;

	public FibonacciController(FibonacciService service) {
		super();
		this.service = service;
	}

	@PostMapping()
	public ResponseEntity<?> createFibonacci(@RequestBody FibonacciDTO input) {
		if (input.getValue() <= 0) {
			return ResponseEntity.badRequest().body("El valor inroducido tiene que ser mayor a 0");
		}

		return ResponseEntity.status(HttpStatus.OK).body(this.service.createFibonacci(input.getValue()));
	}

}
