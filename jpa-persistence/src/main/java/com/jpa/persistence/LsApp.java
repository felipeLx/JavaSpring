package com.jpa.persistence;

import com.jpa.persistence.persistence.model.Project;
import com.jpa.persistence.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class LsApp {

	@Autowired
	private IProjectService projectService;

	public static void main(final String ...args) {
		SpringApplication.run(LsApp.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		Project project = new Project("My First Project", LocalDate.now());
		projectService.save(project);

		Optional<Project> optionalProject = projectService.findById(1L);
		optionalProject.ifPresent(System.out::println);
	}
}
