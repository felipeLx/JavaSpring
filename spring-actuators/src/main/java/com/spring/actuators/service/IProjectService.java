package com.spring.actuators.service;

import com.spring.actuators.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
