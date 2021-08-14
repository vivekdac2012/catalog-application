package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vks.catalog.app.exception.ResourceNotFoundException;
import com.vks.catalog.app.model.CategoryAttribute;
import com.vks.catalog.app.repository.CategoryAttributeReporsitory;

@Service
public class CategoryAttributeServiceImpl implements CategoryAttributeService {
	
	private CategoryAttributeReporsitory attributeReporsitory;
	
	public CategoryAttributeServiceImpl(CategoryAttributeReporsitory attributeReporsitory ) {
		this.attributeReporsitory = attributeReporsitory;
	}

	@Override
	public CategoryAttribute save(CategoryAttribute categoryAttribute) {
		return attributeReporsitory.save(categoryAttribute);
	}

	@Override
	public Optional<CategoryAttribute> findById(Long id) throws ResourceNotFoundException{
		return attributeReporsitory.findById(id);
	}

	@Override
	public List<CategoryAttribute> findAll() {
		return attributeReporsitory.findAll();
	}

}
