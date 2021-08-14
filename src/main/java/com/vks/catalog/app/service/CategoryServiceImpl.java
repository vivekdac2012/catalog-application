package com.vks.catalog.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vks.catalog.app.model.Category;
import com.vks.catalog.app.repository.CategoryReporsitory;

@Service
public class CategoryServiceImpl implements CategoryService{

	CategoryReporsitory categoryReporsitory;
	
	public CategoryServiceImpl(CategoryReporsitory categoryReporsitory) {
		this.categoryReporsitory = categoryReporsitory;
	}
	
	@Override
	public Category save(Category category) {
		return this.categoryReporsitory.save(category);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return this.categoryReporsitory.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return this.categoryReporsitory.findAll();
	}

}
