package com.vks.catalog.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CategoryAttribute> categoryAttributes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> products;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryAttribute> getCategoryAttributes() {
		return categoryAttributes;
	}

	public void setCategoryAttributes(List<CategoryAttribute> categoryAttributes) {
		this.categoryAttributes = categoryAttributes;
	}

}
