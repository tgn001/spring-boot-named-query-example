package com.techgeeknext.controller;

import com.techgeeknext.model.Employee;
import com.techgeeknext.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    /**
     * Get the employee by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        try {
           // retrieve the record from database
            Optional<Employee> empObj = Optional.ofNullable(employeeRepository.findById(id));

            //check if employee exist in database
            if (empObj.isPresent()) {
                return new ResponseEntity<>(empObj.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Get the employee by name
     *
     * @param name
     * @return ResponseEntity
     */
    @GetMapping("/employee/name/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) {
        try {
            // retrieve the record from database
            Optional<Employee> empObj = Optional.ofNullable(employeeRepository.findByName(name));

            //check if employee exist in database
            if (empObj.isPresent()) {
                return new ResponseEntity<>(empObj.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * Get the employee by role
     *
     * @param role
     * @return ResponseEntity
     */
    @GetMapping("/employee/role/{role}")
    public ResponseEntity<Employee> getEmployeeByRole(@PathVariable("role") String role) {
        try {
            // retrieve the record from database
            Optional<Employee> empObj = Optional.ofNullable(employeeRepository.findByRole(role));

            //check if employee exist in database
            if (empObj.isPresent()) {
                return new ResponseEntity<>(empObj.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Create new employee
     *
     * @param employee
     * @return ResponseEntity
     */
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeRepository
                .save(Employee.builder()
                        .name(employee.getName())
                        .role(employee.getRole())
                        .build());
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    /**
     * Get all the employees
     *
     * @return ResponseEntity
     */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
