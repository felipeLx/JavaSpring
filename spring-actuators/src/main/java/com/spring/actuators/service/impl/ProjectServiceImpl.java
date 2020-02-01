package com.spring.actuators.service.impl;

import com.spring.actuators.persistence.model.Project;
import com.spring.actuators.persistence.repository.IProjectRepository;
import com.spring.actuators.service.IProjectService;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

}