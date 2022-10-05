package com.example.PruebaFibonacci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PruebaFibonacci.DTO.FibonacciDTO;
import com.example.PruebaFibonacci.response.ResponseHandler;
import com.example.PruebaFibonacci.service.FibonacciService;

@RestController
@RequestMapping("/fibonacci/calculator")
public class FibonacciController {

	private final FibonacciService service;

	public FibonacciController(FibonacciService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Object> createFibonacci(@RequestBody FibonacciDTO input) {
		try {
			if (input.getValue() <= 0) {
				return ResponseHandler.generateResponse("El valor introducido tiene que ser mayor a 0",
						HttpStatus.BAD_REQUEST, input.getValue());
			}
			return ResponseHandler.generateResponse("¡Datos recuperados con éxito!", HttpStatus.OK,
					this.service.createFibonacci(input.getValue()));
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping
	public ResponseEntity<Object> mostConsulted() {
		try {
			return ResponseHandler.generateResponse("¡Datos recuperados con éxito!", HttpStatus.OK,
					this.service.mostConsulted());
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

}
