package com.kitchenstory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenstory.model.Product;
import com.kitchenstory.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> listProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	public Optional<Product> findProduct(long id) {
		
		return productRepository.findById(id);
	}
	
	public void delete(long  id) {
			
		if(!productRepository.findById(id).equals(Optional.empty()))
		{
						productRepository.deleteById(id);
	    } 
	           
	}
	
	public Product updateProduct(long id) {
		
		return productRepository.findById(id).get();
				
	}
	
	
	
	public List<Product> findProductbyName(String name) {
	
	 return productRepository.findByAproductnameStartingWith(name);
	}
	
	public List<Product> findProductbyName2(String name) {
		
		 return productRepository.findByProductName(name);
		}
}
