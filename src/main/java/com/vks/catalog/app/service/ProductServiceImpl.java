package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.Product;
import com.vks.catalog.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long id) throws ResourceNotFoundException {
		return this.productRepository.findById(id);
	}

	@Override
	public Product save(Product product) {
		return this.productRepository.save(product);
	}

}
