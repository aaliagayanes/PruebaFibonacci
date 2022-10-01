package com.example.PruebaFibonacci;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.PruebaFibonacci.entitys.Fibonacci;
import com.example.PruebaFibonacci.repository.FibonacciRepository;
import com.example.PruebaFibonacci.service.FibonacciService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FibonacciTests {

	@Autowired
	private FibonacciRepository repository;

	@Test
	public void testSaveFibonacci() {
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.setId(2);
		fibonacci.setValue(20);
		this.repository.save(fibonacci);
	}

	@Test
	public void updateCount() {
		long count = 10;
		long idExist = 5;
		this.repository.updateCont(count, idExist);
		Optional<Fibonacci> fibo = this.repository.findById(idExist);
		assertEquals(fibo.get().getCount(),count);
	}

	@Test
	public void getLast() {
		this.repository.lastElemt();
	}

	@Test
	public void finById() {
		long number = 6;
		Optional<Fibonacci> fibo = this.repository.findById(number);
		assertEquals(fibo.get().getId(), number);
	}

	@Test
	public void fibonacciService() throws Exception {
		long await = 13;
		FibonacciService service = new FibonacciService(this.repository);
		long result = service.createFibonacci(6);
		assertEquals(await, result);
	}

	@Test
	public void fibonacciNew() throws Exception {
		long await = 89;
		FibonacciService service = new FibonacciService(this.repository);
		long result = service.createFibonacci(10);
		assertEquals(await, result);
	}

}
