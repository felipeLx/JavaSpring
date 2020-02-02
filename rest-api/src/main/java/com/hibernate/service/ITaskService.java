package com.hibernate.service;

import com.hibernate.persistence.model.Task;

import java.util.Optional;

public interface ITaskService {
    Optional<Task> findById(Long id);

    Task save(Task project);
}