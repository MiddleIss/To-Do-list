package com.example.todo_list.serviceImpl;

import com.example.todo_list.dto.TaskDto;
import com.example.todo_list.dto.form.TaskForm;
import com.example.todo_list.exception.*;
import com.example.todo_list.mapper.TaskMapper;
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
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public void createTask(TaskForm form) {
        if (taskRepository.existsByTaskNumber(form.getTaskNumber())) {
            throw new EntityAlreadyExistsException("Task already exists with task number: " + form.getTaskNumber());
        }
        Task task = Task.builder()
                .name(form.getName())
                .description(form.getDescription())
                .completed(form.getCompleted())
                .taskNumber(form.getTaskNumber())
                .build();
        taskRepository.save(task);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return taskMapper.toDto(getById(id));
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }

}
