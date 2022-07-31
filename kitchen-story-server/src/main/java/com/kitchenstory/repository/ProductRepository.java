package com.kitchenstory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kitchenstory.model.Product;
import com.kitchenstory.model.User;


public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByAproductnameStartingWith(String name);
	/*
	@Query("select * from product where lower(productname) like lower(concat('%', ?1,'%'))")
	public Product findByProductname(String name);*/
	
	@Query("select u from Product u where lower(u.aproductname) like concat('%',  ?1,'%')")
	public List<Product> findByProductName(String name);
	
	
	
}
