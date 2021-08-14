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
import com.vks.catalog.app.model.CategoryAttribute;
import com.vks.catalog.app.service.CategoryAttributeService;

@RestController
@RequestMapping("/api/category-attribute")
public class CategoryAttributeController {

	private CategoryAttributeService categoryAttributeService;

	public CategoryAttributeController(CategoryAttributeService categoryAttributeService) {
		this.categoryAttributeService = categoryAttributeService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<CategoryAttribute> saveCategory(@RequestBody CategoryAttribute categoryAttribute) {
		return ResponseEntity.ok(this.categoryAttributeService.save(categoryAttribute));
	}

	@GetMapping("/{id}")
	public ResponseEntity<? extends Object> getCategoryAttributeById(@PathVariable Long id) {
		Optional<CategoryAttribute> categoryAttribute = this.categoryAttributeService.findById(id);
		if (categoryAttribute.isPresent()) {
			return new ResponseEntity<CategoryAttribute>(categoryAttribute.get(), HttpStatus.FOUND);
		} else {
			throw new ResourceNotFoundException("Category attribute id: " + id + " is not found.");
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryAttribute>> getAllCategory() {
		List<CategoryAttribute> categories = this.categoryAttributeService.findAll();
		return ResponseEntity.ok(categories);
	}

}