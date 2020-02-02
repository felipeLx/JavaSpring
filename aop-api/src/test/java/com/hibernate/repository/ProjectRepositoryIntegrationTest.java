package com.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hibernate.persistence.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hibernate.persistence.model.Project;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void givenNewProject_whenSaved_thenSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        assertNotNull(projectRepository.save(newProject));
    }

    @Test
    public void givenProjectCreated_whenFindById_thenSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retreivedProject = projectRepository.findById(newProject.getId());
        assertEquals(retreivedProject.get(), newProject);
    }
}