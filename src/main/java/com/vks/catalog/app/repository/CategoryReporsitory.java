package com.vks.catalog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vks.catalog.app.model.Category;

@Repository
public interface CategoryReporsitory extends JpaRepository<Category, Long> {

}
