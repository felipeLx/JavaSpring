package com.app.spring;

import com.app.spring.persistence.model.Project;
import com.app.spring.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class LsApp {

	@Autowired
	private IProjectService projectService;

	private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

	@Value("${additional.info}")
	private String additional;

	public static void main(final String... args) {
		SpringApplication.run(LsApp.class, args);
	}

	/*
	start like that to see the log message when start the application

	@PostConstruct
	public void postConstruct() {
		Project project = new Project("My First Project", LocalDate.now());
		projectService.save(project);

		Optional<Project> optionalProject = projectService.findById(1L);
		optionalProject.ifPresent(System.out::println);
	}
	 */

	@PostConstruct
	public void postConstruct() {
		LOG.info("Additional Property {}", additional);
	}
}