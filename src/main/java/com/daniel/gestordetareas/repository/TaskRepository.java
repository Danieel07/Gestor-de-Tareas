package com.daniel.gestordetareas.repository;

import com.daniel.gestordetareas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
