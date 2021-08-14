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
import com.vks.catalog.app.model.Category;
import com.vks.catalog.app.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.save(category));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<? extends Object> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = this.categoryService.findById(id);
		if (category.isPresent()) {
			return new ResponseEntity<Category>(category.get(), HttpStatus.FOUND);
		} else {
			throw new ResourceNotFoundException("Category id: " + id + " not found.");
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> categories = this.categoryService.findAll();
		return ResponseEntity.ok(categories);
	}

}
