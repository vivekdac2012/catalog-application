package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.Category;

public interface CategoryService {

	Category save(Category category);
	Optional<Category> findById(Long id) throws ResourceNotFoundException;;
	List<Category> findAll();
	
}