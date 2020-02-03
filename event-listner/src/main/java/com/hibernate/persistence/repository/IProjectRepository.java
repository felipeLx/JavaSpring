package com.hibernate.persistence.repository;

import com.hibernate.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Iterable<Project> findByNameContaining(String name);
}