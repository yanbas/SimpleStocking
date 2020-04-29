package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Employee;
import com.simplestocking.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        employee.setCreatedDate(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        employee.getEmployee_id();
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
