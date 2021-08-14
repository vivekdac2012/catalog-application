package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.Product;

public interface ProductService {
	
	Product save(Product product);
	Optional<Product> getProductById(Long id) throws ResourceNotFoundException;;
	List<Product> getAllProducts();
	
}
