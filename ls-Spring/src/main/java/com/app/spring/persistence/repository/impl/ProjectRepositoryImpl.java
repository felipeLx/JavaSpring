package com.app.spring.persistence.repository.impl;

import com.app.spring.persistence.model.Project;
import com.app.spring.persistence.repository.IProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if(existingProject == null) {
            projects.add(project);
            return project;
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
            return project;
        }
    }
}
