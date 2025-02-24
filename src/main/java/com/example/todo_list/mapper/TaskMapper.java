package com.example.todo_list.mapper;

import com.example.todo_list.dto.TaskDto;
import com.example.todo_list.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
}
