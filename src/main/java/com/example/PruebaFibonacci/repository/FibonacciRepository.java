package com.example.PruebaFibonacci.repository;


import java.util.List;

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
	
	@Query(value ="select f.id from public.fibonacci f order by f.count desc limit 3", nativeQuery = true)
	public List<Long> mostConsulted();
	
	
}
