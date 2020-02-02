package com.hibernate.persistence.repository;

import com.hibernate.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {
}
