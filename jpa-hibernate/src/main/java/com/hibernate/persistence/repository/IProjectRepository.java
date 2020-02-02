package com.hibernate.persistence.repository;

import com.hibernate.persistence.model.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProjectRepository  {

    Optional<Project> findById(Long id);

    Project save(Project project);
}