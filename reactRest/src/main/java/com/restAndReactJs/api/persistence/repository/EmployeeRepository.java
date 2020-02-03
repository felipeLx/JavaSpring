package com.restAndReactJs.api.persistence.repository;

import com.restAndReactJs.api.persistence.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
