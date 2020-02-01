package com.app.spring.service.impl;

import com.app.spring.persistence.model.Project;
import com.app.spring.persistence.repository.IProjectRepository;
import com.app.spring.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding Project By ID {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Saving Project {}", project);
        return projectRepository.save(project);
    }
}
