package com.daniel.gestordetareas.repository;

import com.daniel.gestordetareas.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
