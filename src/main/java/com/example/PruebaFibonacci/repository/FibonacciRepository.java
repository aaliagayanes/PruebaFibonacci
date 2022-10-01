package com.example.PruebaFibonacci.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PruebaFibonacci.entitys.Fibonacci;

public interface FibonacciRepository extends JpaRepository<Fibonacci, Long> {
	
	@Query(value = "SELECT * FROM  public.fibonacci ORDER BY id DESC  LIMIT 1", nativeQuery = true)
	public Fibonacci lastElemt();
	
	@Modifying
    @Query(value = "UPDATE public.fibonacci SET count =:count WHERE id=:idExiste", nativeQuery = true)
	public void updateCont(@Param("count")long count, @Param("idExiste") long idExiste);
	
	
}
