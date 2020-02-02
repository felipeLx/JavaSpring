package com.hibernate.service;

import com.hibernate.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);

    Project save(Project project);

    Iterable<Project> findAll();

    void delete(Long id);

    Iterable<Project> findByName(String name);
}