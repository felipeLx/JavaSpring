package com.spring.actuators.persistence.repository;

import com.spring.actuators.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    Project save(Project project);
}