package com.hibernate.service.impl;

import com.hibernate.persistence.model.Task;
import com.hibernate.persistence.repository.ITaskRepository;
import com.hibernate.service.ITaskService;

import java.util.Optional;

public class TaskServiceImpl implements ITaskService {
    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task project) {
        return taskRepository.save(project);
    }
}