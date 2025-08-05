package com.daniel.gestordetareas.model;
import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *  Clase mapeada con JPA para la base de datos, con relacion de de Muchos a uno con la clase Category
 */
@Entity
public class Task {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;

    // Relacion de Muchos a uno
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //Contructor vacío
    public Task() {
    }
    // Constructor con parámetos
    public Task(long id, String title, String description, LocalDate dueDate, String priority, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
    }
    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
