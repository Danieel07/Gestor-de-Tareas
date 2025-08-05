package com.daniel.gestordetareas.model;
import jakarta.persistence.*;
/**
 *  Clase mapeada con JPA para la base de datos
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // Constructor Vacío
    public Category() {}

    // Constructor con Parametros
    public Category(String name) {
        this.name = name;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
