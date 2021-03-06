package com.techgeeknext.repository;

import com.techgeeknext.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findById(long id);
    Employee findByName(String name);
    Employee findByRole(String role);
}
