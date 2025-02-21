package com.example.todo_list.controller;

import com.example.todo_list.dto.form.TaskForm;
import com.example.todo_list.model.Task;
import com.example.todo_list.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createTask(@RequestBody @Valid TaskForm form) {
        taskService.createTask(form);
    }
}
