package com.example.PruebaFibonacci.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FIBONACCI")
public class Fibonacci {
	
	@Id
	private long id;
	
	private long value;
	
	private long count;
	
	private long next;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getNext() {
		return next;
	}

	public void setNext(long next) {
		this.next = next;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Fibonacci() {
		super();
	}

	public Fibonacci(long id) {
		this.id = id;
	}

	public Fibonacci(long id, long value, long count, long next) {
		this.id = id;
		this.value = value;
		this.count = count;
		this.next = next;
	}
	
	public void increment() {
		this.count = count + 1;
	}
	
}
