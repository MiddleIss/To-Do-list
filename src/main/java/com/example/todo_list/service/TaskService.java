package com.example.todo_list.service;

import com.example.todo_list.dto.form.TaskForm;
import com.example.todo_list.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    void createTask(TaskForm form);
}
