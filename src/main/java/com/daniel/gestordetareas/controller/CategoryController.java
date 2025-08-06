package com.daniel.gestordetareas.controller;

import com.daniel.gestordetareas.model.Category;
import com.daniel.gestordetareas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Obtener todas la categorias
    @RequestMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //Obtener Categoria Por ID
    @RequestMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }

    //Crear Categoria
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    //Actulizar categoria Existente
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Optional<Category> existingCategory = categoryService.getCategoryById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(updatedCategory.getName());
            return categoryService.saveCategory(category);
        } else {
            return null;
        }
    }

    //Eliminar una Categoria
    @DeleteMapping
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}
