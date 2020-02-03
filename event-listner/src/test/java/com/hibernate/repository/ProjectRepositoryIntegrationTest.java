package com.hibernate.repository;


import java.time.LocalDate;
import java.util.Optional;
import com.hibernate.persistence.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hibernate.persistence.model.Project;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        assertThat(projectRepository.save(newProject)).isNotNull();
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retreivedProject = projectRepository.findById(newProject.getId());
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }
}