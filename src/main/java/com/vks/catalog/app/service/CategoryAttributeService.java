package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.CategoryAttribute;

public interface CategoryAttributeService {

	CategoryAttribute save(CategoryAttribute categoryAttribute);
	Optional<CategoryAttribute> findById(Long id) throws ResourceNotFoundException;
	List<CategoryAttribute> findAll();
	
}
