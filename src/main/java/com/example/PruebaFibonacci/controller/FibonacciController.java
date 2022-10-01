package com.example.PruebaFibonacci.controller;


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
	public long createFibonacci(@RequestBody FibonacciDTO input ) throws Exception {
		return this.service.createFibonacci(input.getValue());
	}

}
