package com.app.spring.service;

import com.app.spring.config.TestConfig;
import com.app.spring.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project saveProject = projectService.save(new Project("test_name", LocalDate.now()));

        assertThat(saveProject, is(notNullValue()));
    }


}
