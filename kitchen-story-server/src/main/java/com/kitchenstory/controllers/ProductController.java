package com.kitchenstory.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kitchenstory.model.Product;
import com.kitchenstory.response.MessageResponse;
import com.kitchenstory.services.ProductService;


@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/auth")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/saveProducts")
	// @RequestMapping(name="/movies", method=RequestMethod.POST)
	private ResponseEntity<?> saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		//return product.getId();
		return ResponseEntity.ok(new MessageResponse(product.getAproductname() + " has been saved"));
	}
	
	@GetMapping("/listProducts")
	private ResponseEntity<?> getProducts() {
		List<Product> products=productService.listProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/getProduct/{id}")
	private ResponseEntity<?> getProduct(@PathVariable("id")Integer id) {
		Optional<Product> product=productService.findProduct(id);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/getProductName/{name}")
	private ResponseEntity<?> getProductName(@PathVariable("name")String name) {
		List<Product> product=productService.findProductbyName(name);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/updateProducts/{id}")
	private ResponseEntity<?> updateProducts(@PathVariable("id")Integer id,@RequestBody Product body ) {
		
		Product currentProd=productService.updateProduct(id);
		currentProd.setAproductname(body.getAproductname());
		currentProd.setBproductcategory(body.getBproductcategory());
		currentProd.setCprice(body.getCprice());
		
		productService.saveProduct(currentProd);
		
		//List<Product> products=productService.listProducts();
		return ResponseEntity.ok(new MessageResponse(currentProd.getAproductname() +" has been edited"));
	}
	
	
	@DeleteMapping("/product/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	private ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		productService.delete(id);
		//System.out.println(id);
		return ResponseEntity.ok(new MessageResponse("Id deleted"));
	}


}
