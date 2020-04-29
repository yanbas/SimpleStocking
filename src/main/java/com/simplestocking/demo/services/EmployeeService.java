package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(Employee employee);
    Employee update(Employee employee);
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    void delete(int id);

}
