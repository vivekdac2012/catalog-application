package com.vks.catalog.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.Product;
import com.vks.catalog.app.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService  = productService;
	}
	
	@PostMapping("/save") 
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<? extends Object> getProductById(@PathVariable Long id) {
		Optional<Product> product = this.productService.getProductById(id);
		if(product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.FOUND);
		}else {
			throw new ResourceNotFoundException("Product id: "+id+" is not found.");
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
