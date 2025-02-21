package com.example.todo_list.serviceImpl;

import com.example.todo_list.dto.form.TaskForm;
import com.example.todo_list.model.Task;
import com.example.todo_list.repository.TaskRepository;
import com.example.todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(TaskForm form) {
        Task task = Task.builder()
                .name(form.getName())
                .description(form.getDescription())
                .completed(form.getCompleted())
                .build();
        taskRepository.save(task);
    }
}
