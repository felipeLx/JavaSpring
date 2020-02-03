package com.hibernate;

import com.hibernate.service.IProjectService;
import com.hibernate.persistence.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class LsApp {

	public static void main(final String ...args) {
		SpringApplication.run(LsApp.class, args);
	}
}