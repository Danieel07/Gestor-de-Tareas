package com.daniel.gestordetareas.controller;


import com.daniel.gestordetareas.model.Task;
import com.daniel.gestordetareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //EndPoint para Obtener las Tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //Obtener una Tarea por ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    //Crear una nueva tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    //Actualizar un tarea Existente
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task updateTask) {
        Optional<Task> exisitingTask =  taskService.getTaskById(id);
        if(exisitingTask.isPresent()) {
            Task task = exisitingTask.get();
            task.setTitle(updateTask.getTitle());
            task.setDescription(updateTask.getDescription());
            task.setDueDate(updateTask.getDueDate());
            task.setPriority(updateTask.getPriority());
            task.setCategory(updateTask.getCategory());
            return taskService.saveTask(task);
        }else {
            return null;
        }
    }

    //Eliminar una tarea
    @DeleteMapping
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }

}
