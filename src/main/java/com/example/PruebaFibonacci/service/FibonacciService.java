package com.example.PruebaFibonacci.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.PruebaFibonacci.entitys.Fibonacci;
import com.example.PruebaFibonacci.repository.FibonacciRepository;

@Service
public class FibonacciService {

	private final FibonacciRepository repository;

	public FibonacciService(FibonacciRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public long createFibonacci(long number) {

		Optional<Fibonacci> exist = this.repository.findById(number);
		if (!exist.isEmpty()) {
			exist.get().increment();
			long count = exist.get().getCount();
			long idExiste = exist.get().getId();
			this.repository.updateCont(count, idExiste);
			return exist.get().getValue();
		}
		long next = 1, res = 1, prev, pos = 1;
		Fibonacci lastFibo = this.repository.lastElemt();
		if (lastFibo != null) {
			next = lastFibo.getNext();
			res = lastFibo.getValue();
			pos = lastFibo.getId() + 1;
		}
		Fibonacci fibo = new Fibonacci();

		for (long i = pos; i <= number; i++) {
			prev = next;
			next = next + res;
			res = prev;

			fibo.setId(i);
			fibo.setValue(res);
			fibo.setNext(next);
			fibo.setCount(0);
			this.repository.save(fibo);
		}

		return this.repository.findById(number).get().getValue();

	}

}
